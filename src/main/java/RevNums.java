import java.util.Scanner;

public class RevNums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        cal(m,n);
        //cal(100,112);
    }
    public static void cal(int m,int n) {
         m = rev(m);
        n = rev(n);
        System.out.print(rev(m+n));

    }
    public static int rev(int m) {
        String val = String.valueOf(m);
        StringBuffer sb = new StringBuffer();
        for (int i = val.length()-1;i>=0;i--) {
            if (val.charAt(i) != '0') {
                sb.append(val.charAt(i));
            }
        }
        return Integer.valueOf(sb.toString());
    }

}
