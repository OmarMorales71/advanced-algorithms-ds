
package omar.algorithms.prim;

import java.util.ArrayList;
import java.util.PriorityQueue;
import omar.algorithms.nodos.GraphNode;


public class PrimsAlgorithm {
    
    ArrayList<GraphNode> nodeList=new ArrayList<GraphNode>();
    
    public PrimsAlgorithm(ArrayList<GraphNode> nodeList){
        this.nodeList=nodeList;
    }
    
    public void addUndirectedEdge(int a, int b, int c){
        GraphNode A = nodeList.get(a);
        GraphNode B = nodeList.get(b);
        
        A.getNeighbours().add(B);
        A.getNeighboursWeight().put(B, c);
        
        
        B.getNeighbours().add(A);
        B.getNeighboursWeight().put(A, c);
    }
    
    public int prim(){
        PriorityQueue<GraphNode> queue = new PriorityQueue<GraphNode>();
        nodeList.get(0).setDistance(0);
        queue.add(nodeList.get(0));
        int n=0;
        for(int i = 1 ; i<nodeList.size(); i++){
           nodeList.get(i).setDistance(Integer.MAX_VALUE);
           
           queue.add(nodeList.get(i));
        }
        int costo=0;
        while(!queue.isEmpty()){
            GraphNode current = queue.poll();
            
            if(!current.getIsVisited()){
            costo+=current.getDistance();
                System.out.println("[ "+current.getDistance() +" ]");
            current.setIsVisited(true);
            
            for(GraphNode node: current.getNeighbours()){
                if(!node.getIsVisited()){
                    if(node.getDistance()>current.getNeighboursWeight().get(node)){
                      node.setDistance(current.getNeighboursWeight().get(node));
                      
                      queue.remove(node);
                      queue.add(node);
                    }
                }
            }
            }
        }
        
        
        
        return costo;
    }
}
