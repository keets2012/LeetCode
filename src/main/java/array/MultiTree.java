package array;


import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String rootStr = in.nextLine();
        String[] a = rootStr.split(" ");
        TreeNode node = new TreeNode();
        node.setSelfId(Integer.valueOf(a[0]));
        for (int i = 1;i<a.length;i++) {
            TreeNode child = new TreeNode();
            child.setSelfId(Integer.valueOf(a[i]));
            child.setParentNode(node);
            node.addChildNode(child);
        }
        AtomicInteger integer = new AtomicInteger(1);
        integer.addAndGet(1);
        //integer.
        while (in.hasNextLine()) {
            String []line = in.nextLine().split(" ");
            TreeNode p = new TreeNode();
            p.setSelfId(Integer.valueOf(line[0]));
            TreeNode parent = p.getParentNode();

        }
    }

}
