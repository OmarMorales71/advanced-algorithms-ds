/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.disjointSet;

import java.util.ArrayList;
import omar.algorithms.nodos.GraphNode;

public class DisjointSet {

    public ArrayList<GraphNode> nodes = new ArrayList<GraphNode>();

    public static void makeSet(GraphNode Node) {
        DisjointSet set = new DisjointSet();

        set.nodes.add(Node);

        Node.setSet(set);

    }

    public static DisjointSet findSet(GraphNode Node) {
        return Node.getSet();
    }

    public static boolean union(GraphNode Node, GraphNode Node2) {
        DisjointSet set_1 = Node.getSet();
        DisjointSet set_2 = Node2.getSet();

        if (set_1.equals(set_2)) {
            return false;
        } else {
            if(set_1.nodes.size()>=set_2.nodes.size()){
                
                for(GraphNode node: set_2.nodes){
                    node.setSet(set_1);
                    set_1.nodes.add(node);
                }
            }else{
                for(GraphNode node: set_1.nodes){
                    node.setSet(set_2);
                    set_2.nodes.add(node);
                }
            }
            return true;
        }

    }
}
