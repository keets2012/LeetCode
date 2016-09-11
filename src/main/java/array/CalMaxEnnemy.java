package array;

import java.util.Scanner;

public class CalMaxEnnemy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int k = in.nextInt();
            int count = 0;
            int sum = (int) Math.sqrt(k);
            for (int  i = 0;i<=k;i++) {
                for (int j = 0;j<=k;j++) {
                    int s = (int) (Math.sqrt(i) + Math.sqrt(j));
                    if (s==sum) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }


}
