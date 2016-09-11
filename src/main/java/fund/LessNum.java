package fund;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LessNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        while (in.hasNextInt()) {
            list.add(in.nextInt());
        }
        cal(list);
    }

    public static void cal(List<Integer> list) {
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(i)) {
                    count++;
                    break;
                }
            }
            a[i] = count;
            System.out.println(count + " ");
        }
    }
}
