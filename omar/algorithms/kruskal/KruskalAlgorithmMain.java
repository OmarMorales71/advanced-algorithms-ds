/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.kruskal;

import java.util.ArrayList;
import omar.algorithms.nodos.GraphNode;

/**
 *
 * @author kikir
 */
public class KruskalAlgorithmMain {

    public static void main(String args[]) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

        for (int i = 0; i < 7; i++) {
            nodeList.add(new GraphNode("V" + i, i));
        }

        KruskalAlgorithm kruskal = new KruskalAlgorithm(nodeList);

//        kruskal.addUndirectedEdge(1, 2, 15);
//        kruskal.addUndirectedEdge(1, 3, 20);
//        kruskal.addUndirectedEdge(2, 3, 13);
//        kruskal.addUndirectedEdge(2, 4, 5);
//        kruskal.addUndirectedEdge(3, 4, 10);
//        kruskal.addUndirectedEdge(3, 5, 6);
//        kruskal.addUndirectedEdge(4, 5, 8);
        kruskal.addUndirectedEdge(1, 2, 5);
        kruskal.addUndirectedEdge(1, 3, 8);
        kruskal.addUndirectedEdge(1, 7, 3);
        kruskal.addUndirectedEdge(2, 5, 6);
        kruskal.addUndirectedEdge(2, 6, 7);
        kruskal.addUndirectedEdge(3, 4, 6);
        kruskal.addUndirectedEdge(3, 5, 12);
        kruskal.addUndirectedEdge(3, 6, 2);
        kruskal.addUndirectedEdge(4, 5, 10);
        kruskal.addUndirectedEdge(4, 7, 12);
        kruskal.addUndirectedEdge(5, 7, 7);

        System.out.println("Minimun Spanning Tree: " + kruskal.mstKruskal());
    }

}
