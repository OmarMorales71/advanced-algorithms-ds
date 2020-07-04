/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.dijkstra;

import java.util.ArrayList;
import omar.algorithms.nodos.GraphNode;

/**
 *
 * @author kikir
 */
public class DijkstraAlgorithmMain {
    public static void main(String [] args){
            ArrayList<GraphNode> nodeList = new ArrayList<>();

            for(int i=0;i<5;i++){
                nodeList.add(new GraphNode(Character.toString((char)('A'+i)), i));
                
            }
            
            DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(nodeList);
            
            dijkstra.addDirectedWeightEdge(0, 2, 6);
            dijkstra.addDirectedWeightEdge(0, 3, 6);
            dijkstra.addDirectedWeightEdge(1, 0, 3);
            dijkstra.addDirectedWeightEdge(2, 3, 2);
            dijkstra.addDirectedWeightEdge(3, 2, 1);
            dijkstra.addDirectedWeightEdge(3, 1, 1);
            dijkstra.addDirectedWeightEdge(4, 1, 4);
            dijkstra.addDirectedWeightEdge(4, 3, 2);
            
            dijkstra.Dijkstra(4);
            
            dijkstra.sssp(0);
            
        
    }
}
