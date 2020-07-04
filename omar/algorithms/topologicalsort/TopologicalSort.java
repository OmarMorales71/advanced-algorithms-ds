
package omar.algorithms.topologicalsort;

import java.util.ArrayList;
import java.util.Stack;
import omar.algorithms.nodos.GraphNode;

public class TopologicalSort {
    ArrayList<GraphNode> nodeList;   
    Stack<GraphNode> topologicalStack;   
    
    public TopologicalSort(ArrayList<GraphNode> nodeList){
        this.nodeList=nodeList;
        this.topologicalStack=new Stack<GraphNode>();
    }
    
    public Stack<GraphNode> TopologicalSortAlgorithm(){
        
        for(GraphNode currentRoot : nodeList){
            if(!currentRoot.getIsVisited()){
                solvingTopologicalSort(currentRoot);
            }
        }

        return topologicalStack;
    }

    private void solvingTopologicalSort(GraphNode currentRoot) {
        if(!currentRoot.getIsVisited())currentRoot.setIsVisited(true);
        
        for(GraphNode currentNeighbour : currentRoot.getNeighbours()){
            if(!currentNeighbour.getIsVisited()){
                solvingTopologicalSort(currentNeighbour);
            }
        }
        
        topologicalStack.add(currentRoot);
    }
    
    public void addDirectedEdge(int a, int b){
        GraphNode A = nodeList.get(a-1);
        GraphNode B = nodeList.get(b-1);
        
        A.getNeighbours().add(B);
    }
}
