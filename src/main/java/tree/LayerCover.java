package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by keets on 9/8/16.
 */
public class LayerCover {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return list;
        }
        TreeNode node = root;
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            list.add(node.val);
        }
        return list;
    }
}
