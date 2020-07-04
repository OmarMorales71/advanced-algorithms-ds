
package omar.algorithms.topologicalsort;

import java.util.ArrayList;
import java.util.Stack;
import omar.algorithms.nodos.GraphNode;

public class TopologicalSortMain {

    public static void main(String [] args){
        
        ArrayList<GraphNode> nodeList=new ArrayList<GraphNode>();
        
        for(int i=0;i<8;i++){
            nodeList.add(new GraphNode(Character.toString((char)('A'+i)), i+1));
        }
        
        
        TopologicalSort myTS = new TopologicalSort(nodeList);
        
        myTS.addDirectedEdge(1, 3);
        myTS.addDirectedEdge(2, 3);
        myTS.addDirectedEdge(2, 4);
        myTS.addDirectedEdge(3, 5);
        myTS.addDirectedEdge(4, 6);
        myTS.addDirectedEdge(5, 6);
        myTS.addDirectedEdge(5, 8);
        myTS.addDirectedEdge(6, 7);
        Stack<GraphNode> theTopologicalSort= myTS.TopologicalSortAlgorithm();
        
        while(!theTopologicalSort.empty()){
            System.out.println(" [ "+theTopologicalSort.pop()+" ] ");
        }
        
        
        
    }
}
