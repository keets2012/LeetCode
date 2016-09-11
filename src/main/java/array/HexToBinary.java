package array;

import java.util.Scanner;

/**
 * Created by keets on 8/6/16.
 */
public class HexToBinary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            int a[] = new int[num];
            for (int i = 0; i<num;i++) {
                a[i] = in.nextInt();
                //System.out.println(a[i]);
            }
            print(num,a);
        }
        //System.out.println(reverse(new int[]{1,2,3,4}));
    }

    public static void print(int num,int []a) {
        for (int i= 0;i<num;i++) {
            if (a[i]%2 == 0) {
                String binary = Integer.toBinaryString(a[i]);
                char tmp[] = new char[binary.length()];
                for (int j=0;j<binary.length();j++) {
                    tmp[j] = binary.charAt(j);
                }
                String res = reverse(tmp);
                res = Integer.valueOf(res,2).toString();
                a[i] = Integer.valueOf(res);
            }
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static String reverse(char[] str) {
        //System.out.println(str);
        for (int i = 0;i<str.length/2;i++) {
            char tmp = str[i];
            str[i] = str[str.length - i - 1];
            str[str.length - i - 1] = tmp;
        }
        String res = "";
        for (int i = 0;i<str.length;i++ ) {
            res += str[i];
        }
       // System.out.println(res);
        return res;
    }
}
