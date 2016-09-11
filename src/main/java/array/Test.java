package array;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        for (int i = 0; i < n; i++) {
            LuckyNumber(Integer.valueOf(in.nextLine()));
        }
    }

    public static void LuckyNumber(int n) {
        //System.out.println("n:  "+n);
        int f = 0, g = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            f = sum(i);
            g = binarySum(i);
            if (f == g) {
                count++;
            }
        }

        for (int j = 1; j <= 4; j++) {
            int i = j;
            while (i < n && i <1) {

            }
        }
        System.out.println(count);
    }

    public static int sum(int a) {
        int s = 0;
        while (a / 10 != 0) {
            s += a % 10;
            a = a / 10;
        }
        s += a;
        return s;
    }

    public static int binarySum(int a) {
        int s = 0;
        String str = Integer.toBinaryString(a).toString();
        for (int i = 0; i < str.length(); i++) {
            s = s + Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return s;
    }

    public static void fun(int m, int n) {
        int count = 0;
        for (int i = m; i <= n; i++) {
            int geWei, shiWei, baiWei;
            baiWei = i / 100;
            shiWei = (i - baiWei * 100) / 10;
            geWei = i - baiWei * 100 - shiWei * 10;
            if (i == geWei * geWei * geWei + shiWei * shiWei * shiWei + baiWei * baiWei * baiWei) {
                System.out.println(i);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("no");
        }

    }

}
