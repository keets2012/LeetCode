package crawl;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.io.IOUtils.toByteArray;

/**
 * Hello world!
 */
public class TestRarBg {

    public static final String RARBG_TPL = "http://rarbg.to/torrents.php?search={1}&category={2}&page={3}";
    public static final String RARBG_BASEURI = "http://rarbg.to";

    public static void main(String[] args) {

        String searchKeyword = "bones";
        String category = "41";
        String stopTimeString = "2016-11-10 01:00:03";
        long stopTime = LocalDateTime.parse(stopTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toInstant(ZoneOffset.of("+02")).toEpochMilli();
        int maxStopPage = 20;

        StringTokenizer st = new StringTokenizer(searchKeyword, "|");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            searchForTorrents(token, maxStopPage, stopTime, category);
        }

    }

    private static void searchForTorrents(String searchKeyword, int maxStopPage, long stopTime, String category) {
        String dis = "Z:\\" + searchKeyword;
        //ThreadPoolExecutor
        ExecutorService executor = Executors.newCachedThreadPool();
        executor = Executors.newFixedThreadPool(4);

        executor = Executors.newScheduledThreadPool(5);
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println();
            }
        }, 1, 2, TimeUnit.SECONDS);


        Runtime.getRuntime().availableProcessors();
        File disDir = new File(dis);
        if (!disDir.exists()) {
            disDir.mkdir();
        }
        try (CloseableHttpClient httpclient = buildClient();) {
            boolean isFetch = true;
            int pageIdx = 0;
            List<RarbgItem> itemList = new ArrayList<>();

            while (isFetch && pageIdx <= maxStopPage) {
                ++pageIdx;
                Random r = new Random();
                randomSleep(1000, 3000);
                String rarbgUrl = StringUtils.replace(RARBG_TPL, "{1}", searchKeyword);
                rarbgUrl = StringUtils.replace(rarbgUrl, "{2}", category);
                rarbgUrl = StringUtils.replace(rarbgUrl, "{3}", String.valueOf(pageIdx));

                HttpGet getItemListReq = new HttpGet(rarbgUrl);
                getItemListReq.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
                StringBuilder rarbgPage = new StringBuilder();
                System.out.println("Fetch page " + pageIdx);

                try (CloseableHttpResponse svrQueryResponse = httpclient
                        .execute(getItemListReq)) {
                    if (svrQueryResponse.getStatusLine().getStatusCode() != 200) {
                        throw new HttpException("Fetch page" + pageIdx + " failed. Key word:" +
                                searchKeyword + " Category:" + category);
                    }
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(svrQueryResponse.getEntity()
                                    .getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        rarbgPage.append(inputLine);
                        rarbgPage.append(System.lineSeparator());
                    }
                    EntityUtils.consume(svrQueryResponse.getEntity());
                    Document doc = Jsoup.parse(rarbgPage.toString(), "UTF-8");
                    doc.setBaseUri(RARBG_BASEURI);
                    Elements trs = doc.select("body > table:nth-child(6) > tbody > tr > td:nth-child(2) > div > table > tbody > tr:nth-child(2) > td > table.lista2t > tbody > tr");
                    if (trs.size() > 0) {

                        trs.remove(0);

                        for (Element ele : trs) {
                            RarbgItem item = new RarbgItem();
                            Element detailEle = ele.select("td:nth-child(2)").get(0);
                            Element timeEle = ele.select("td:nth-child(3)").get(0);

                            item.setTitle(ele.select("td:nth-child(2) > a:nth-child(1)").text());
                            item.setUrl(ele.select("td:nth-child(2) > a:nth-child(1)").attr("abs:href"));

                            LocalDateTime localDateTime = LocalDateTime.parse(timeEle.text(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                            item.setTime(localDateTime.toInstant(ZoneOffset.of("+02")).toEpochMilli());
                            //System.out.println(detailEle.toString());
                            //System.out.println(timeEle.toString());
                            if (item.getTime() < stopTime) {
                                isFetch = false;
                                break;
                            }
                            itemList.add(item);
                        }
                    } else {
                        isFetch = false;
                    }
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    System.out.println();
                }
            }
            for (RarbgItem item : itemList) {
                HttpGet getItemReq = new HttpGet(item.getUrl());
                getItemReq.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
                randomSleep(500, 1500);
                try (CloseableHttpResponse getItemResponse = httpclient.execute(getItemReq);
                     InputStream inputStream = getItemResponse.getEntity().getContent()) {
                    if (getItemResponse.getStatusLine().getStatusCode() != 200) {
                        throw new HttpException("Fetch page:" + item.getUrl());
                    }
                    String itemPage = IOUtils.toString(inputStream, "UTF-8");
                    EntityUtils.consume(getItemResponse.getEntity());
                    Document doc = Jsoup.parse(itemPage, "UTF-8");
                    doc.setBaseUri(RARBG_BASEURI);
                    Elements trs = doc.select("tr");
                    for (Element ele : trs) {
                        Elements tds = ele.select("td");
                        if (tds.size() > 0 && tds.get(0).text().equals("Torrent:")) {
                            Element torrentTd = tds.get(1);
                            item.setTorrentUrl(torrentTd.select("a:nth-child(2)").get(0).attr("abs:href"));
                            break;
                        }
                    }
                    for (Element ele : trs) {
                        Elements tds = ele.select("td");
                        if (tds.size() > 0 && tds.get(0).text().equals("Poster:")) {
                            Element posterTd = tds.get(1);
                            item.setCoverUrl(posterTd.select("img").get(0).absUrl("src"));
                            break;
                        }
                    }
                }
            }

            for (RarbgItem item : itemList) {
                System.out.println(item.toString());
                HttpGet getCoverReq = new HttpGet(item.getCoverUrl());
                getCoverReq.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
                randomSleep(100, 300);
                try (CloseableHttpResponse getItemResponse = httpclient.execute(getCoverReq);
                     InputStream inputStream = getItemResponse.getEntity().getContent()) {
                    byte[] imgBytes = IOUtils.toByteArray(inputStream);
                    Files.write(Paths.get(dis, item.getTitle() + ".jpg"), imgBytes);
                }

                HttpGet getTorrentReq = new HttpGet(item.getTorrentUrl());
                getTorrentReq.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
                randomSleep(2000, 3000);
                try (CloseableHttpResponse getItemResponse = httpclient.execute(getTorrentReq);
                     InputStream inputStream = getItemResponse.getEntity().getContent()) {
                    byte[] torrentBytes = IOUtils.toByteArray(inputStream);
                    Files.write(Paths.get(dis, item.getTitle() + ".torrent"), torrentBytes);
                }
            }
        } catch (KeyManagementException | NoSuchAlgorithmException
                | KeyStoreException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        }
    }

    private static CloseableHttpClient buildClient() throws NoSuchAlgorithmException,
            KeyStoreException, KeyManagementException {
        boolean ifForceDns = false;
        boolean ifUseProxy = false;
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        if (ifUseProxy) {
            HttpHost proxy = new HttpHost("cn-proxy.jp.oracle.com", 80);
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(
                    proxy);
            httpClientBuilder.setRoutePlanner(routePlanner);
        }
        if (ifForceDns) {
            SSLContextBuilder builder = SSLContexts.custom();
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain,
                                         String authType) throws CertificateException {
                    return true;
                }
            });
            SSLContext sslContext = builder.build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslContext, new HostnameVerifier() {

                @Override
                public boolean verify(String hostname,
                                      SSLSession session) {
                    // TODO Auto-generated method stub
                    return true;
                }
            });

            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                    .<ConnectionSocketFactory>create()
                    .register("http",
                            PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslsf).build();

            DnsResolver dnsResolver = new SystemDefaultDnsResolver() {
                @Override
                public InetAddress[] resolve(final String host)
                        throws UnknownHostException {
                    System.setProperty("sun.net.spi.nameservice.provider.1",
                            "dns,sun");
                    System.setProperty("sun.net.spi.nameservice.nameservers",
                            "8.8.8.8");
                    return new InetAddress[]{InetAddress.getByName(host)};
                }
            };
            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(
                    socketFactoryRegistry, dnsResolver);
            httpClientBuilder.setConnectionManager(cm);
        }
        RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.DEFAULT)
                .build();
        // Create a local instance of cookie store
        CookieStore cookieStore = new BasicCookieStore();
        // Populate cookies if needed
        String cookieKeys[] = {"LastVisit", "vDVPaqSe", "expla2"};
        String cookieValues[] = {String.valueOf(System.currentTimeMillis()), "r9jSB2Wk", "1%7CSat%2C%2002%20Jul%202016%2020%3A36%3A06%20GMT"};
        for (int i = 0; i < cookieKeys.length; ++i) {
            BasicClientCookie cookie1 = new BasicClientCookie(cookieKeys[i], cookieValues[i]);
            cookie1.setDomain("rarbg.to");
            cookie1.setPath("/");
            cookieStore.addCookie(cookie1);
        }
        // Set the store
        CloseableHttpClient httpclient = httpClientBuilder.setRedirectStrategy(
                new LaxRedirectStrategy()).setDefaultRequestConfig(globalConfig).
                setDefaultCookieStore(cookieStore).
                build();
        return httpclient;
    }

    private static void randomSleep(long min, long max) {
        Random r = new Random();
        try {
            double interval = (double) (max - min);
            Thread.sleep((long) (r.nextDouble() * interval + min));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
