package tpackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal {
    //dfs
    public void dfSearchTraversing(GraphNode node, List<GraphNode> visited) {
        // 判断是否遍历过
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        System.out.println("节点：" + node.getLabel());
        for (int i = 0; i < node.edgeList.size(); i++) {
            dfSearchTraversing(node.edgeList.get(i).getNodeRight(), visited);
        }
    }

    //bfs
    public static void bfSearchTraversing(GraphNode node) {
        List<GraphNode> visited = new ArrayList<GraphNode>(); // 已经被访问过的元素
        Queue<GraphNode> q = new LinkedList<GraphNode>(); // 用队列存放依次要遍历的元素
        q.offer(node);
        while (!q.isEmpty()) {
            GraphNode currNode = q.poll();
            if (!visited.contains(currNode)) {
                visited.add(currNode);
                System.out.println("节点：" + currNode.getLabel());
                for (int i = 0; i < currNode.edgeList.size(); i++) {
                    q.offer(currNode.edgeList.get(i).getNodeRight());
                }
            }
        }
    }

}
