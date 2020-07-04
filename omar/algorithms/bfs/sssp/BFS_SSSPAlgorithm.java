/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.bfs.sssp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import omar.algorithms.nodos.GraphNode;

/**
 *
 * @author kikir
 */
public class BFS_SSSPAlgorithm {

    ArrayList<GraphNode> nodeList;

    public BFS_SSSPAlgorithm(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void bfs(int source) {
        GraphNode Source = nodeList.get(source);

        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();

        queue.add(Source);

        while (!queue.isEmpty()) {
            GraphNode current = queue.pop();

            if (!current.getIsVisited()) {
                current.setIsVisited(true);

                for (GraphNode currentNeighbour : current.getNeighbours()) {
                    if (!currentNeighbour.getIsVisited()) {
                        if (currentNeighbour.getParent()==null) {
                            currentNeighbour.setParent(current);
                        }
                        
                        queue.add(currentNeighbour);
                    }
                }
            }

        }

    }
    
    public void sssp(int dest){
        GraphNode D = nodeList.get(dest);
        
        Stack<GraphNode> journey = new Stack<GraphNode>();
        while(D!=null){
            journey.add(D);
            D=D.getParent();
        }
        System.out.println("");
        System.out.print(" [ " + journey.pop() + " ] ");
        
        while(!journey.isEmpty()){
            System.out.print("--> [ "+journey.pop()+" ] ");
        }
    }
    
    public void addUndirectedEdge(int a, int b){
        GraphNode A = nodeList.get(a);
        GraphNode B = nodeList.get(b);
        
        A.getNeighbours().add(B);
        B.getNeighbours().add(A);
    }
    public void addDirectedEdge(int a, int b){
        GraphNode A = nodeList.get(a);
        GraphNode B = nodeList.get(b);
        
        A.getNeighbours().add(B);
    }

}
