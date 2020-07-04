/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.prim;

import java.util.ArrayList;
import omar.algorithms.nodos.GraphNode;

/**
 *
 * @author kikir
 */
public class PrimsAlgorithmMain {
    
    public static void main (String[] args){
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        
        for(int i = 0; i<5; i++){
            nodeList.add(new GraphNode("V"+i, i));
        }
        
        PrimsAlgorithm prim = new PrimsAlgorithm(nodeList);
        
        prim.addUndirectedEdge(0, 1, 10);
        prim.addUndirectedEdge(0, 2, 20);
        prim.addUndirectedEdge(1, 2, 30);
        prim.addUndirectedEdge(1, 3, 5);
        prim.addUndirectedEdge(2, 3, 15);
        prim.addUndirectedEdge(2, 4, 6);
        prim.addUndirectedEdge(3, 4, 8);
        
        System.out.println(prim.prim());
    }
}
