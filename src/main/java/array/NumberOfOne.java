package array;


public class NumberOfOne {
    public static int NumberOf1(int n) {
        int count = 0;
        String str =Integer.toBinaryString(n).toString();
        for (int i = 0;i<str.length();i++) {
            if (str.charAt(i)=='1')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(-10));
    }
}
