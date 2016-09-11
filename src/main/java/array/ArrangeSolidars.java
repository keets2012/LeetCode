package array;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ArrangeSolidars {
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        int num = 0;
        String cases = "";
        while (in.hasNextLine()) {
            if (count<2)
            {
                if (count == 0) {
                    num = in.nextInt();
                    //System.out.println(num);
                    count ++;
                }
                if (count == 1) {
                    cases = in.next();
                    System.out.println(handle(num,cases));
                    count = 0;
                }
            }
            //System.out.println(in.nextLine());
        }
    }
    public static int handle(int num , String cases) {

        String ca[] = cases.split("");
        HashMap<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0;i<ca.length;i++) {
            List<Integer> integerList = new ArrayList<Integer>();
            for (int j = 0 ; j<ca.length;j++) {
                integerList.add(Integer.valueOf(ca[i].charAt(j)));
                //set.add(Integer.valueOf(ca[i].charAt(j)));
            }
            map.put(i,integerList);
        }
        for (Integer key:map.keySet()) {
            List<Integer> integerList = map.get(key);
            for (Integer s:integerList) {

                set.add(s);

            }
        }
        return 0;
    }*/

    private static int ans;

    public static int getAns(String[] str, int n) {
        ans = 0;
        int[] vis = {0, 0, 0, 0, 0, 0};
        dfs(str, vis, n, 0);
        return ans;
    }

    public static void dfs(String[] str, int[] vis, int n, int p) {
        if (p == n) {
            ans++;
            return ;
        }
        for (int i = 0; i < str[p].length(); i++) {
            if (vis[str[p].charAt(i) - '0'] == 0) {
                vis[str[p].charAt(i) - '0'] = 1;
                dfs(str, vis, n, p + 1);
                vis[str[p].charAt(i) - '0'] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = in.next();
            }

            int ans = getAns(str, n);
            System.out.println(ans);
        }
        in.close();
    }
}
