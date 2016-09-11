package array;

import java.util.Scanner;


public class ChangeFib {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            print(in.nextInt());
        }
    }

    public static void print(int num) {
        int max = num;
        int min = num;
        for (int i = 0; i <= num; i++) {
            if (f(i) >= num) {
                max = f(i);
                min = f(i - 1);
                break;
            }
        }
        if (max - num > num - min) {
            System.out.println(num - min);
        } else {
            System.out.println(max - num);
        }
    }

    public static int f(int a) {
        int x = 1, y = 1;
        if (a == x || a == y) {
            return 1;
        }

        for (int i = 3; i <= a; i++) {
            int temp = y;
            y = x + y;
            x = temp;

        }
        return y;
    }
}
