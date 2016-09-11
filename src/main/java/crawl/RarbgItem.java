package crawl;

/**
 * Created by Yao on 7/3/2016.
 */
public class RarbgItem {
    private String url;
    private String title;
    private long time;
    private String coverUrl;
    private String torrentUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getTorrentUrl() {
        return torrentUrl;
    }

    public void setTorrentUrl(String torrentUrl) {
        this.torrentUrl = torrentUrl;
    }

    @Override
    public String toString() {
        return "RarbgItem{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", time=" + time +
                ", coverUrl='" + coverUrl + '\'' +
                ", torrentUrl='" + torrentUrl + '\'' +
                '}';
    }
}
