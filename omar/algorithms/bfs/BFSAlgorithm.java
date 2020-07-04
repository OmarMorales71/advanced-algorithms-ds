/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import omar.algorithms.nodos.GraphNode;

/**
 *
 * @author kikir
 */
public class BFSAlgorithm {
    
    ArrayList<GraphNode> nodeList;
    
    public BFSAlgorithm(ArrayList<GraphNode> nodeList){
        this.nodeList=nodeList;
    }
    
    public void bfs(){
        for(GraphNode node: nodeList){
            if(!node.getIsVisited()){
                            bfsVisit(node);

            }
        }
    }
    
    public void addUndirectedEdge(int a, int b){
        nodeList.get(a-1).getNeighbours().add(nodeList.get(b-1));
        nodeList.get(b-1).getNeighbours().add(nodeList.get(a-1));
    }
    
    public void addDirectedEdge(int a, int b){
        nodeList.get(a-1).getNeighbours().add(nodeList.get(b-1));
    }

    private void bfsVisit(GraphNode node) {
        LinkedList<GraphNode>queue = new LinkedList<>();
        
        queue.add(node);
        
        while(!queue.isEmpty()){
            GraphNode p = queue.pop();
            
            if(!p.getIsVisited()){
                System.out.print(" [ "+p+" ] ");
                p.setIsVisited(true);
                ArrayList<GraphNode> neighbours = p.getNeighbours();
                for(GraphNode thisNode: neighbours){
                    if(!thisNode.getIsVisited()){
                        queue.add(thisNode);
                    }
                }
            }
            
        }
    }
    
}
