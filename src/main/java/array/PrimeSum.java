package array;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class PrimeSum {
    public static List<Integer> ListPrime(int n) {
    /*
     * false为质数,true为合数
     */
        boolean[] primeList = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (!primeList[i]) {

                int j = i * i;

                if (j > n) // 所有合数都已被标记
                    break;
                if (i > 2) {
                /*
                 * 将所有能被此质数整除的奇数标记为合数
                 */
                    while (j <= n) {
                        primeList[j] = true;
                        j = j + i + i;
                    }
                } else {
                /*
                 * 将所有大于2的偶数标记为合数
                 */
                    while (j <= n) {
                        primeList[j] = true;
                        j = j + i;
                    }
                }
            }
        }
        List<Integer> listPrime = new LinkedList<Integer>();
        if( n > 1 )
            listPrime.add(2);
        for (int i = 3; i <= n; i += 2) {
            if (!primeList[i]) {
                listPrime.add(i);
            }
        }
        System.out.println(listPrime.size());
        return listPrime;
    }

    public static void main(String[] args) {
        List<Integer> list = ListPrime(1000);
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = 0;
        for (int i = 0;i<list.size()&&list.get(i)<=num/2;i++) {
            if (list.contains(num - list.get(i))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
