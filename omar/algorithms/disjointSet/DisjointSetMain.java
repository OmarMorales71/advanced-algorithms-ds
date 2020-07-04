package omar.algorithms.disjointSet;

import java.util.ArrayList;
import omar.algorithms.nodos.GraphNode;

public class DisjointSetMain {

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

        for (int i = 0; i < 10; i++) {
            GraphNode nodito = new GraphNode("V"+i, i);
            nodeList.add(nodito);
            DisjointSet.makeSet(nodito);
            
        }
        
        DisjointSet.union(nodeList.get(0), nodeList.get(1));
        System.out.println("*************************\n");
        for(GraphNode nodo: DisjointSet.findSet(nodeList.get(0)).nodes){
            System.out.print(" [ "+nodo+" ] ");
        }
        System.out.println("*************************\n");
        DisjointSet.union(nodeList.get(4), nodeList.get(5));
        System.out.println("*************************\n");
        for(GraphNode nodo: DisjointSet.findSet(nodeList.get(4)).nodes){
            System.out.print(" [ "+nodo+" ] ");
        }
        System.out.println("*************************\n");
        
        DisjointSet.union(nodeList.get(7), nodeList.get(8));
        System.out.println("*************************\n");
        for(GraphNode nodo: DisjointSet.findSet(nodeList.get(7)).nodes){
            System.out.print(" [ "+nodo+" ] ");
        }
        System.out.println("*************************\n");
        
        System.out.println("*************************\n");
        
        DisjointSet.union(nodeList.get(1), nodeList.get(5));
        System.out.println("*************************\n");
        for(GraphNode nodo: DisjointSet.findSet(nodeList.get(1)).nodes){
            System.out.print(" [ "+nodo+" ] ");
        }
        System.out.println("*************************\n");
        
        System.out.println("*************************\n");
        
        DisjointSet.union(nodeList.get(4), nodeList.get(8));
        System.out.println("*************************\n");
        for(GraphNode nodo: DisjointSet.findSet(nodeList.get(4)).nodes){
            System.out.print(" [ "+nodo+" ] ");
        }
        System.out.println("*************************\n");
    }
}
