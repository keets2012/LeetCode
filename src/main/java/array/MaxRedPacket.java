package array;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxRedPacket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        for (int i = 0;i<n;i++) {
            String line  = scan.nextLine();
            String a[] = line.split(" ");
            cal(a);
        }

    }

    public static void cal(String[] line) {
        if (line.length == 0) {
            System.out.println("0");
            return;
        }
        if (line.length == 1) {
            System.out.println(line[0]);
            return;
        }
        int sum1 = 0;
        int sum2 = 0;
        int len = line.length/2;
        List<Integer> list= new ArrayList<Integer>();
        for (int i=0;i<line.length;i++) {
            list.add(Integer.valueOf(line[i]));
            if (i%2 == 0 && len >0) {
                sum1 += Integer.valueOf(line[i]);
            }
            if (i%2 == 1) {
                sum2 +=Integer.valueOf(line[i]);
            }
            len--;
        }
        int sum = sum1>sum2?sum1:sum2;
        System.out.println(sum);
    }
}
