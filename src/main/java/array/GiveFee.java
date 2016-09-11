package array;


import java.io.BufferedInputStream;
import java.util.Scanner;
/*
 *   总费用的范围为   A / 0.95 <= f <= A / 0.9
 *   由于魔卡为整数,所以总费用范围为min <=f <= max  f为整数
 */

public class GiveFee {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int A = in.nextInt();
            int B = in.nextInt();
            int min = (int) Math.ceil(A / 0.95);
            int max = (int) Math.floor(A / 0.9);
            int ans = 0;
            if (min <= B) {
                if (max > B) {
                    ans = B / 5 - min / 5;
                } else {
                    ans = max / 5 - min / 5;
                }
                if (min % 5 == 0) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
        in.close();
    }
}
