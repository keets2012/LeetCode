package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by keets on 9/11/16.
 */
public class GeoHash {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        cal(list,n,-90,90,6);
        for (int i = 0;i<list.size();i++) {
            System.out.print(list.get(i));
        }
    }
    public static void cal(List<Integer> list,int n,int left,int right,int len) {
        if (list.size() == len)
            return;
        if (n>(left+right)/2) {
            list.add(1);
            cal(list,n,(left+right)/2,right,len);

        } else {
            list.add(0);
            cal(list,n,left,(left+right)/2,len);
        }
    }
}
