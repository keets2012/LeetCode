package array;

import java.util.Scanner;

public class SelectMaxMin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextLine()) {
            int count = in.nextInt();
            int[] num = new int[count];
            for (int i = 0;i<count;i++) {
                num[i] = in.nextInt();
                //System.out.println(num[i]);
            }
            //System.out.println("qqq");
            find(count,num);
        }
    }
    public static void find(int count , int[] num) {
        if (count == 1) {
            System.out.println("1 1");
            return;
        }
        int max = num[0];
        int min = num[0];
        for (int i= 1;i<count;i++) {
            if (num[i]>=max || num[i]<=min) {
                if (num[i]>=max) {
                    max = num[i];
                } else {
                    min = num[i];
                }
            }
        }

        print(max,min,num,count);
    }

    public static void print(int max , int min,int[] num,int count) {
        int maxAns = 0;
        int minCount = 0;
        int maxCount = 0;
        for (int i= 0 ;i<num.length;i++) {
            if (num[i] == max || num[i] == min) {
                if (num[i] == max) {
                    maxCount ++;
                } else {
                    minCount ++;
                }
            }
        }
        int minCouple = Math.abs(num[1]-num[0]);
        int minNum = 0;
        for (int i = 0;i<count-1;i++) {
            for (int j = i+1;j<count;j++) {
                int sub = Math.abs(num[i] - num[j]);
                if (sub < minCouple) {
                    minCouple = sub;
                    minNum = 1;
                }
                else {
                    if (minCouple == sub) {
                        minNum++;
                    }
                }
            }
        }
        System.out.print(minNum+" "  +maxCount*minCount);
    }
}
