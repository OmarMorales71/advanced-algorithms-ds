/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.bfs.sssp;

import java.util.ArrayList;
import omar.algorithms.nodos.GraphNode;

/**
 *
 * @author kikir
 */
public class BFS_SSSPAlgorithmMain {
 
    public static void main (String [] args){
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        
        for(int i = 0; i<10;i++){
            nodeList.add(new GraphNode(Integer.toString(i), i));
        }
        
        BFS_SSSPAlgorithm sssp = new BFS_SSSPAlgorithm(nodeList);
        
        sssp.addUndirectedEdge(0, 8);
        sssp.addUndirectedEdge(1, 2);
        sssp.addUndirectedEdge(1, 3);
        sssp.addUndirectedEdge(1, 7);
        sssp.addUndirectedEdge(1, 9);
        sssp.addUndirectedEdge(2, 4);
        sssp.addUndirectedEdge(2, 8);
        sssp.addUndirectedEdge(3, 4);
        sssp.addUndirectedEdge(4, 5);
        sssp.addUndirectedEdge(5, 6);
        sssp.addUndirectedEdge(6, 7);
        sssp.addUndirectedEdge(8, 9);
        
        sssp.bfs(3);
        
        sssp.sssp(1);
    }
}
