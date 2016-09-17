package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinGraph {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        int a[][] = new int[len][len];
        for (int i = 0;i<len;i++) {
            String str = in.nextLine();
            String s[] = str.split(",");
            for (int j=0;j<s.length;j++)
                a[i][j] = Integer.valueOf(s[j]);
        }
        cal(a);
        int min  = list.get(0);
        for (int i = 0;i<list.size();i++) {
            if (min>list.get(i)) {
                min = list.get(i);
            }
        }
        System.out.print(min);
    }

    public static void cal(int a[][]) {
        int order[] = new int[a.length];
        for (int i=0;i<a.length;i++) {
            order[i] = i;
        }
        arrange(order,0,order.length,a);

    }

    public static void swap(int[] str, int i, int j) {
        int temp ;
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void arrange(int[] str, int st, int len,int a[][]) {
        if (st == len - 1) {
            int sum = 0;
            for (int i = 0; i < len-1; i++) {
                sum+=a[str[i]][str[i+1]];
            }
            list.add(sum);
        } else {
            for (int i = st; i < len; i++) {
                swap(str, st, i);
                arrange(str, st + 1, len,a);
                swap(str, st, i);
            }
        }

    }
}
