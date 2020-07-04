/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.bfs;

import java.util.ArrayList;
import omar.algorithms.nodos.GraphNode;

/**
 *
 * @author kikir
 */
public class BFSAlgorithmMain {

    public static void main(String[] args) {
        
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        
        for(int i=1; i<=8;i++){
            nodeList.add(new GraphNode("V"+i, i));
        }
        
        BFSAlgorithm myBFS = new BFSAlgorithm(nodeList);
        
        myBFS.addUndirectedEdge(1, 2);
        myBFS.addUndirectedEdge(1, 3);
        myBFS.addUndirectedEdge(2, 6);
        myBFS.addUndirectedEdge(3, 4);
        myBFS.addUndirectedEdge(5, 7);
        myBFS.addUndirectedEdge(6, 7);
        myBFS.addUndirectedEdge(7, 8);
        
        myBFS.bfs();
    }
    
}
