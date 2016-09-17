package array;

import java.util.Scanner;

public class MaxStock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String a[] = str.split(",");
        cal(a);
    }

    public static void cal(String[] a) {
        int []s = new int[a.length];
        for (int i = 0;i<a.length;i++) {
            s[i] = Integer.valueOf(a[i]);
        }
        int min = min(s,s.length,0);
        int max = max(s,s.length,0);
        if (min<max) {
            System.out.print(s[max] - s[min]);
            return;
        }
        else {
            int sub1 = 0;
            int sub2 = 0;
            int min2 = min(s,max,0);
            int max2 = max(s,s.length,min);
            sub1 = s[max] - s[min2];
            sub2 = s[max2] -s[min];
            System.out.print(sub1>sub2?sub1:sub2);
            return;
        }

    }

    public static int max(int a[],int len,int st) {
        int m = a[st];
        int pos = st;
        for (int i = st; i < len; i++) {
            if (a[i] > m) {
                m = a[i];
                pos = i;
            }
        }
        return pos;
    }

    public static int min(int a[],int len,int st) {
        int m = a[st];
        int pos = st;
        for (int i = st; i < len; i++) {
            if (a[i] < m) {
                m = a[i];
                pos = i;
            }
        }
        return pos;
    }
}
