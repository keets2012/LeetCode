package array;


import java.util.Arrays;
import java.util.Scanner;

public class DicMax {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            String[] name = new String[n];
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                name[i] = scan.next();
                num[i] = scan.nextInt();
            }
            System.out.println(getCharm(name, num));
        }
    }

    //一个串的charm 只和start，end 的index有关。
    public static String getCharm(String[] name, int[] num) {
        StringBuilder result = new StringBuilder();
        //Arrays.sort(name);
        //System.out.println(name[0]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length; i++) {//找出n>=2 的串
            if (num[i] >= 2) {
                sb.append(name[i] + " ");
                num[i] -= 2;
            }
        }
        String[] head = sb.toString().trim().split(" ");//按字母顺序，拼接head
        Arrays.sort(head);
        for (int i = 0; i < head.length; i++)
            result.append(head[i] + " ");
        System.out.println(result.toString());
        StringBuilder sb2 = new StringBuilder();//对剩下的str 按字母顺序拼接
        for (int i = 0; i < name.length; i++) {
            while (num[i] != 0) {
                sb2.append(name[i] + " ");
                num[i]--;
            }
        }
        String[] mid = sb2.toString().trim().split(" ");
        Arrays.sort(mid);
        String midstr = mid.toString();
        for (int i = 0; i < mid.length; i++)
            result.append(mid[i] + " ");
        System.out.println(result.toString());
        for (int i = 0; i < head.length; i++)//头尾相同，拼接尾部
            result.append(head[i] + " ");
        return result.toString().trim();
    }
}
