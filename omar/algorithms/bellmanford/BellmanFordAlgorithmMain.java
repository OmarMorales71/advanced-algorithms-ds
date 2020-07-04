
package omar.algorithms.bellmanford;

import java.util.ArrayList;
import omar.algorithms.nodos.GraphNode;

public class BellmanFordAlgorithmMain {
    public static void main(String[] args) {
           ArrayList<GraphNode> nodeList=new ArrayList<GraphNode>();
           
           for(int i=0; i<5;i++){
               nodeList.add(new GraphNode(Character.toString((char)('A'+i)), i));
               
               
           }
           
           BellmanFordAlgorithm bellman = new BellmanFordAlgorithm(nodeList);
           
           bellman.addDirectedEdge(0, 2, 6);
           bellman.addDirectedEdge(0, 3, -6);
           bellman.addDirectedEdge(1, 0, 3);
           bellman.addDirectedEdge(2, 3, 2);
           bellman.addDirectedEdge(3, 1, 1);
           bellman.addDirectedEdge(3, 2, 1);
           bellman.addDirectedEdge(4, 1, 4);
           bellman.addDirectedEdge(4, 3, 2);
           
           
           if(bellman.bellmanFord(4)){
               bellman.sssp(0);
           }else{
               System.out.println("Ciclo Negativo Encontrado");
           }
           
    }
}
