package array;


import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int s = in.nextInt();
        int len = in.nextInt();
        int a[] = new int[len];
        for (int i = 0;i<len;i++) {
            a[i] = in.nextInt();
        }
        System.out.print(search(a,s));

    }

    public static int search(int[] nums, int num) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            //与中间值比较确定在左边还是右边区间,以调整区域
            if (num > nums[mid]) {
                low = mid + 1;
            } else if (num < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        for (int i = 0;i<nums.length;i++) {
            if (nums[i]>num) {
                return -1 - i;
            }
        }
        return -1;
    }
}
