/*
package tpackage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphSimpleExample {
    private final int MAX_VERTS = 20;
    private GraphNodeBean nodeList[];
    private int adjMat[][];
    private int nVerts;

    public GraphSimpleExample(){
        nodeList = new GraphNodeBean[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addNode(char label){
        nodeList[nVerts++] = new GraphNodeBean(label);
    }

    public void addEdge(int start,int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayGraphNode(int v){
        System.out.println(nodeList[v].label);
    }

    */
/**
     * 获得未访问节点
     * @param v
     * @return
     *//*

    public int getAdjUnvisitedVertex(int v){
        for (int i = 0; i < nVerts; i++) {
            if(adjMat[v][i]==1 && nodeList[i].isVisited == false)
                return i;
        }
        return -1;
    }

    */
/**
     * deft first
     *//*

    public void dfs(){
        @SuppressWarnings("rawtypes")
        Stack<Integer> theStack = new Stack<Integer>();
        nodeList[0].isVisited = true;
        displayGraphNode(0);
        theStack.push(0);

        while(!theStack.isEmpty()){
            int v = getAdjUnvisitedVertex(theStack.peek());
            if(v == -1)
                theStack.pop();
            else{
                nodeList[v].isVisited = true;
                displayGraphNode(v);
                theStack.push(v);
            }
        }
//      for (int i = 0; i < nVerts; i++) {
//          nodeList[i].isVisited = false;
//      }
    }

    public void bds(){
        Queue<Integer> theQueue = new LinkedList<Integer>();

        nodeList[0].isVisited = true;
        displayGraphNode(0);
        theQueue.offer(0);
        int v2;

        while(!theQueue.isEmpty()){
            int v1 = theQueue.poll();
            while((v2 = getAdjUnvisitedVertex(v1)) != -1){
                nodeList[v2].isVisited = true;
                displayGraphNode(v2);
                theQueue.add(v2);
            }
        }
//      for (int i = 0; i < nVerts; i++) {
//      nodeList[i].isVisited = false;
//  }

    }

}
*/
