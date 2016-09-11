package array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PatchArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int num = in.nextInt();
            int a[] = new int[num];
            for (int i = 0;i<num;i++) {
                a[i] = in.nextInt();
            }
            System.out.println(minPatch(a));
        }
    }
    public static int minPatch(int[] nums) {
        System.out.println(nums.length);
        int miss = 1;
        int add = 0;
        int i = 0;
        int n = 0;
        List<Integer> integerList = new ArrayList<Integer>();
        for (int j = 0 ; j<nums.length;j++) {
            n += nums[j];
            integerList.add(nums[j]);
        }
        Collections.sort(integerList);
        for (int j = 0 ; j<nums.length;j++) {
            nums[j] = integerList.get(j);
        }
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss){
                miss += nums[i++];
            } else {
                return miss;
                /*miss += miss;
                add += 1;*/
            }
        }
        return miss;
    }
}
