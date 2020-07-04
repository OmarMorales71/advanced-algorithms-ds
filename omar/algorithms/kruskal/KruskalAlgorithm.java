package omar.algorithms.kruskal;

import java.util.ArrayList;
import java.util.PriorityQueue;
import omar.algorithms.disjointSet.DisjointSet;
import omar.algorithms.nodos.GraphNode;

public class KruskalAlgorithm {

    ArrayList<GraphNode> nodeList;
    PriorityQueue<Edge> edgeList;

    public KruskalAlgorithm(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        edgeList=new PriorityQueue<Edge>();
    }

    public void addUndirectedEdge(int a, int b, int c) {
        edgeList.add(new Edge(a -1, b - 1, c));
    }

    public int mstKruskal() {
        int costo = 0;

        for (int i = 0; i < nodeList.size(); i++) {
            GraphNode currentNodo = nodeList.get(i);

            DisjointSet.makeSet(currentNodo);

        }

        while (!edgeList.isEmpty()) {
            Edge currentEdge= edgeList.poll();
            
            GraphNode U =nodeList.get(currentEdge.source);
            GraphNode V =nodeList.get(currentEdge.dest);
            if(!DisjointSet.findSet(U).equals(DisjointSet.findSet(V))){
                DisjointSet.union(U, V);
                
                costo+=currentEdge.weight;
            }
        }

        return costo;
    }

}

class Edge implements Comparable<Edge> {

    int source;
    int dest;
    int weight;

    public Edge(int a, int b, int c) {
        source = a;
        dest = b;
        weight = c;
    }

    @Override
    public int compareTo(Edge t) {
        return weight - t.weight;
    }

}
