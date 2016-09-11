package array;

import java.util.Scanner;

public class LuckyBag {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int count = in.nextInt();
            int a[] = new int[count];
            for (int i = 0;i<count;i++) {
                a[i] = in.nextInt();
            }
            print(a);
        }
    }

    public static void print(int nums[]) {
        int ans = 5;
        for (int i=2;i<nums.length;i++) {
            //if ()
            for (int j = 0;j<nums.length;j++) {

            }
        }
        System.out.println(ans);
    }
    public static int sum(int nums[]) {
        int sum = 0;
        for (int i = 0;i<nums.length;i++) {
            sum +=nums[i];
        }
        return sum;
    }
    public static int mSum(int nums[]) {
        int sum = 1;
        for (int i = 0;i<nums.length;i++) {
            sum *=nums[i];
        }
        return sum;
    }

}
