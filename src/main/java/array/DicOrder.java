package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class DicOrder {
    public static void main(String[] args) {
       /* Scanner in  = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            int num = in.nextInt();
            String[] pair = new String[num];
            in.nextLine();
            for (int i = 0;i<num;i++) {
                pair[i] = in.nextLine();
            }

        }*/
        List<String> integerList = new ArrayList<String>();
        integerList.add("1");
        String a[] = {"1", "2"};
        System.out.println(integerList.contains(a));
    }

    public static void findMinDic(String pattern, int num, String[] pairs) {
        List<ArrayList<Integer>> allList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < pairs.length; i++) {
            List<String> integerList = new ArrayList<String>();
            HashSet<String> set = new HashSet<String>();
            String a[] = pairs[i].split(" ");
            for (int j = 0; j < a.length; j++) {
                if (integerList.contains(a[j])) {
                    integerList.add(a[j]);

                }
            }

            //integerList.add()

        }
    }

    public static String compute(String s1, ArrayList<int[]> caihong) {

        char[] tmp1 = s1.toCharArray();
        char swap;
        boolean flag1 = false;

        //flag1为false代表字符串中仍然有不满足字典序的情况
        while (!flag1) {
            //读所有彩虹，判断对应位置的字典序，如果满足条件则交换。
            for (int[] x : caihong) {
                if (tmp1[x[0]] > tmp1[x[1]]) {
                    swap = tmp1[x[0]];
                    tmp1[x[0]] = tmp1[x[1]];
                    tmp1[x[1]] = swap;
                    continue;
                }
                //判断到没有满足字典序情况，便把flag1置true,跳出循环。
                flag1 = true;
            }
        }
        return String.valueOf(tmp1);
    }
}
