package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class PureStr {
    static ArrayList<String> list = new ArrayList<>();



    public static void cal(int m) {
        HashSet<Integer> set = new HashSet<>();
        double sum = Math.pow(3, m);
        if (m < 3) {
            System.out.println((int) sum);
            return;
        }
        int lef = m - 3;
        double sub = 6;
        if (lef == 0) {
            System.out.println((int) (sum - sub));
            return;
        }
        String init[] = {"abc", "acb", "bac", "bca", "cab", "cba"};
        sub = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < lef; i++) {
            StringBuffer sb = new StringBuffer();

            sb.append(init[i].toString());
        }
        System.out.println((int) (sum - sub * 6));
        return;
    }

    public static void cal2(char a[], int st, int m) {
        if (st == m) {
            String str = "";
            for (int i = 0; i < a.length; i++) {
                str += a[i];
            }
            list.add(str);
        }
        else {
            for (char i = 'a' ;i<='c';i++) {
                a[st] = i;
                cal2(a,st+1,m);
            }
        }
    }
    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            cal(in.nextInt());
        }*/
        int m = 3;
        char []a = new char[m];
        cal2(a,0,m);
        System.out.println(list.size());

        for (int i = 0;i<list.size();i++) {
            System.out.println(list.get(i));
        }

    }
}

