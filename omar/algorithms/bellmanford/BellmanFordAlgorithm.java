package omar.algorithms.bellmanford;

import java.util.ArrayList;
import java.util.Stack;
import omar.algorithms.nodos.GraphNode;

public class BellmanFordAlgorithm {

    ArrayList<GraphNode> nodeList;
    ArrayList<Edge> edges;

    public BellmanFordAlgorithm(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        edges = new ArrayList<Edge>();
    }

    public void addDirectedEdge(int a, int b, int c) {
        edges.add(new Edge(a, b, c));
    }

    public boolean bellmanFord(int source) {
        GraphNode S = nodeList.get(source);

        S.setDistance(0);

        for (int i = 1; i < nodeList.size(); i++) {

            for (Edge currentEdge : edges) {
                GraphNode Source = nodeList.get(currentEdge.source);
                GraphNode Dest = nodeList.get(currentEdge.dest);
                int weight = currentEdge.weight;

                if (Source.getDistance() != Integer.MAX_VALUE) {
                    if (Dest.getDistance() > Source.getDistance() + weight) {
                        Dest.setDistance(Source.getDistance() + weight);
                        Dest.setParent(Source);
                    }
                }
            }
        }

        for (Edge currentEdge : edges) {
            GraphNode Source = nodeList.get(currentEdge.source);
            GraphNode Dest = nodeList.get(currentEdge.dest);
            int weight = currentEdge.weight;

            if (Source.getDistance() != Integer.MAX_VALUE) {
                if (Dest.getDistance() > Source.getDistance() + weight) {
                    return false;
                }
            }
        }
        return true;
    }

    public void sssp(int dest) {
        GraphNode D = nodeList.get(dest);
        Stack<GraphNode> stack = new Stack<GraphNode>();

        while (D != null) {
            stack.add(D);
            D = D.getParent();
        }

        System.out.println("");
        System.out.print(" [ " + stack.pop() + " ] ");
        while (!stack.empty()) {
            System.out.print(" --> [ " + stack.pop() + " ] ");

        }
    }

}

class Edge {

    int source;
    int dest;
    int weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}
