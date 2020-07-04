/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.dfs;

import java.util.ArrayList;
import java.util.Stack;
import omar.algorithms.nodos.GraphNode;

/**
 *
 * @author kikir
 */
public class DFSAlgorithm {

    ArrayList<GraphNode> nodeList;

    DFSAlgorithm(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    void addUndirectedEdge(int i, int i0) {
        GraphNode A = nodeList.get(i - 1);
        GraphNode B = nodeList.get(i0 - 1);

        A.getNeighbours().add(B);
        B.getNeighbours().add(A);
    }

    void addDirectedEdge(int i, int i0) {
        GraphNode A = nodeList.get(i - 1);
        GraphNode B = nodeList.get(i0 - 1);

        A.getNeighbours().add(B);
    }

    public void dfs() {

        for (GraphNode theNode : nodeList) {
            if (!theNode.getIsVisited()) {
                dfsAlgorithm(theNode);
            }
        }
    }

    private void dfsAlgorithm(GraphNode theNode) {
        Stack<GraphNode> stack = new Stack<GraphNode>();

        stack.add(theNode);

        while (!stack.isEmpty()) {
            GraphNode p = stack.pop();

            if (!p.getIsVisited()) {
                p.setIsVisited(true);
                System.out.println(" [" + p + " ] ");
                for (GraphNode currentNode : p.getNeighbours()) {
                    if (!currentNode.getIsVisited()) {
                        stack.add(currentNode);
                    }
                }
            }

        }

    }
    public void dfsRecursion() {

        for (GraphNode theNode : nodeList) {
            if (!theNode.getIsVisited()) {
                dfsAlgorithmRecursion(theNode);
            }
        }
    }

    private void dfsAlgorithmRecursion(GraphNode theNode) {
        
        if(theNode==null)return;

        theNode.setIsVisited(true);
        System.out.println(" [ "+theNode+" ] ");
        for(GraphNode currentNode: theNode.getNeighbours()){
            if(!currentNode.getIsVisited()){
                dfsAlgorithmRecursion(currentNode);
            }
        }
    }
}
