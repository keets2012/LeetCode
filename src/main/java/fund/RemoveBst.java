package fund;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveBst {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        String line = in.nextLine();
        String a[] = line.split(" ");
        cal(a, in.nextInt());
        String b[] = line.split(" ");
        cal(b, in.nextInt());
        String c[] = line.split(" ");
        cal(c, in.nextInt());
    }

    public static void cal(String a[], int num) {
        boolean flag;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(num + "")) {
                System.out.print(a[i]);
                flag = true;
            } else {
                flag = false;
            }
            if (i != a.length - 1 && flag) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
