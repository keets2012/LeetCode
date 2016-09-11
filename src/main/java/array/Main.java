package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int[] arr = new int[a];
            for (int i = 0; i < a; i++) {
                arr[i] = in.nextInt();
            }
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (int j = 0; j < b; j++) {
                String k = in.next();
                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 1);
                }
            }
            List<Integer> list = new ArrayList<Integer>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                list.add(entry.getValue());
            }
            cal(arr, list);
        }
    }

    private static void cal(int[] p, List<Integer> array) {
        int[] a = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            a[i] = array.get(i);
        }
        quicksort(p, 0, p.length - 1);
        quicksort(a, 0, a.length - 1);
        int min = 0, max = 0;
        int j = 0;
        for (int i = a.length - 1; j < p.length && i >= 0; i--) {
            min += a[i] * p[j];
            max += a[i] * p[p.length - 1 - j];
            j++;
        }
        System.out.println(min + " " + max);
    }

    static void quicksort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }

}
