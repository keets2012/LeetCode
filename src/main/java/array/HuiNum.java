package array;

import java.util.Scanner;

public class HuiNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int a[] = new int[m];
        for (int i = 0;i<m;i++) {
            a[i] = in.nextInt();
        }
        cal(a);
    }
    public static void cal(int a[]) {
        int m = 1;
        if (m>1) {
            m++;
        }
        System.out.print(m);
    }
}
