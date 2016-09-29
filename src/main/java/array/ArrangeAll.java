package array;


import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

public class ArrangeAll {
    public static ArrayList<String> list = new ArrayList<>();

    public static void swap(String[] str, int i, int j) {
        String temp = new String();
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static ArrayList<String> Permutation(String str) {
        TreeSet<String> tree = new TreeSet<>();
        Stack<String[]> stack = new Stack<>();
        ArrayList<String> results = new ArrayList<>();
        stack.push(new String[]{str, ""});
        do {
            String[] popStrs = stack.pop();
            String oldStr = popStrs[1];
            String statckStr = popStrs[0];
            for (int i = statckStr.length() - 1; i >= 0; i--) {
                String[] strs = new String[]{statckStr.substring(0, i) + statckStr.substring(i + 1), oldStr + statckStr.substring(i, i + 1)};
                if (strs[0].length() == 0) {
                    tree.add(strs[1]);
                } else {
                    stack.push(strs);
                }
            }
        } while (!stack.isEmpty());
        for (String s : tree)
            results.add(s);
        return results;
    }

    public static void arrange(String[] str, int st, int len) {
        if (st == len - 1) {
            String tmp = "";
            for (int i = 0; i < len; i++) {
                tmp += str[i];
            }
            list.add(tmp);
        } else {
            for (int i = st; i < len; i++) {
                swap(str, st, i);
                arrange(str, st + 1, len);
                swap(str, st, i);
            }
        }

    }

    /**
     * @param args 字典序,找后继,结束条件为没有后继了
     *             后继寻找的原则
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str[] = {"a", "a", "c"};

        arrange(str, 0, str.length);
        System.out.println(list.size());
    }
}
