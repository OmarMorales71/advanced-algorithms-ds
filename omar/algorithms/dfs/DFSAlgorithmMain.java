/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.dfs;


import java.util.ArrayList;
import omar.algorithms.nodos.GraphNode;

/**
 *
 * @author kikir
 */
public class DFSAlgorithmMain {

    public static void main(String[] args) {
        
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        
        for(int i=1; i<=7;i++){
            nodeList.add(new GraphNode("V"+i, i));
        }
        
        DFSAlgorithm myDFS = new DFSAlgorithm(nodeList);
        
        myDFS.addUndirectedEdge(1, 2);
        myDFS.addUndirectedEdge(1, 6);
       // myDFS.addUndirectedEdge(2, 3);
        myDFS.addUndirectedEdge(2, 7);
        myDFS.addUndirectedEdge(3, 4);
        myDFS.addUndirectedEdge(4, 5);
        myDFS.addUndirectedEdge(4, 7);
        myDFS.addUndirectedEdge(5, 6);
        
        myDFS.dfsRecursion();
        
    }
    
}
