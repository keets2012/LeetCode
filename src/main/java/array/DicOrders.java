package array;

import java.util.ArrayList;

public class DicOrders {
    public ArrayList<String> Permutation(String str) {
        //ArrayList<String> list = new ArrayList<String>();
        char[] c = str.toCharArray();
        sort(c, 0, c.length - 1);
        System.out.println(c.length);
        return arrange(c, 0, c.length);
    }

    public void swap(char[] c, int i, int j) {
        char temp;
        temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public ArrayList<String> arrange(char[] c, int st, int len) {
        ArrayList<String> list = new ArrayList<String>();
        if (st == len - 1) {
            /*for (int i = 0; i < len; i++) {
                System.out.print(c[i] + "  ");
            }*/
            list.add(new String(c));
            //System.out.println();
        } else {
            for (int i = st; i < len; i++) {
                swap(c, st, i);
                arrange(c, st + 1, len);
                swap(c, st, i);
            }
        }
        return list;
    }

    public void sort(char[] c, int left, int right) {
        //System.out.println(c);
        int dp;
        if (left < right) {
            dp = quick(c, left, right);
            sort(c, left, dp - 1);
            sort(c, dp + 1, right);
        }
    }

    public int quick(char[] c, int start, int end) {
        char p = c[start];
        while (start < end) {
            while (start < end && c[end] >= p)
                end--;
            if (start < end)
                c[start++] = c[end];
            while (start < end && c[start] <= p)
                start++;
            if (start < end)
                c[end--] = c[start];
        }
        c[start] = p;
        return start;
    }

    public static void main(String[] args) {
        String str = "a";
        char c[] = str.toCharArray();
        new DicOrders().sort(c, 0, 0);

        System.out.println(new DicOrders().Permutation("aa").size());
    }


    public void permutation(String inStr, int pos, StringBuffer parentData) {
        if (inStr.length() == 0) {
            return;
        }
        if (inStr.length() == 1) {
            System.out.println("{" + inStr + "}");
            return;
        }
        // here we need a new buffer to avoid to pollute the other nodes.
        StringBuffer buffer = new StringBuffer();
        // copy from the parent node
        buffer.append(parentData.toString());

        // choose the element
        buffer.append(inStr.charAt(pos));

        // get the remnant elements.
        String subStr = kickChar(inStr, pos);

        // got one of the result
        if (subStr.length() == 1) {
            buffer.append(subStr);
            System.out.println(buffer.toString());
            return;
        }

        // here we use loop to choose other children.
        for (int i = 0; i < subStr.length(); i++) {
            permutation(subStr, i, buffer);
        }

    }

    // a simple method to delete the element we choose
    private String kickChar(String src, int pos) {
        StringBuffer srcBuf = new StringBuffer();
        srcBuf.append(src);
        srcBuf.deleteCharAt(pos);
        return srcBuf.toString();
    }


}
