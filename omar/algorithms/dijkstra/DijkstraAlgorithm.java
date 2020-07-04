/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import omar.algorithms.nodos.GraphNode;

/**
 *
 * @author kikir
 */
public class DijkstraAlgorithm {

    private ArrayList<GraphNode> nodeList;
    private PriorityQueue<GraphNode> minHeap;

    public DijkstraAlgorithm(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        minHeap=new PriorityQueue<GraphNode>();
    }

    public void addUndirectedWeightEdge(int a, int b, int c) {
        GraphNode A = nodeList.get(b);
        GraphNode B = nodeList.get(a);

        A.getNeighbours().add(B);
        B.getNeighbours().add(A);

        A.getNeighboursWeight().put(B, c);
        B.getNeighboursWeight().put(A, c);
    }

    public void addDirectedWeightEdge(int a, int b, int c) {
        GraphNode A = nodeList.get(a);
        GraphNode B = nodeList.get(b);

        A.getNeighbours().add(B);

        A.getNeighboursWeight().put(B, c);
    }

    public void Dijkstra(int source){
        GraphNode current = nodeList.get(source);
        current.setDistance(0);
        current.setParent(null);
        fillMinHeap();
        
        while(!minHeap.isEmpty()){
            GraphNode p = minHeap.poll();
            
            p.setIsVisited(true);
            
            for(GraphNode vecino: p.getNeighbours()){
                if(!vecino.getIsVisited()){
                    int x=p.getDistance()+p.getNeighboursWeight().get(vecino);
                    if(x<vecino.getDistance()){
                        vecino.setDistance(x);
                        vecino.setParent(p);
                        
                        minHeap.remove(vecino);
                        minHeap.add(vecino);
                    }
                }
            }
        }
    }
    
    public void sssp(int dest){
        GraphNode D = nodeList.get(dest);
        
        Stack<GraphNode> journey=new Stack<GraphNode>();
        
        
        
        while(D!=null){
        journey.add(D);
        D=D.getParent();
        }
        
        System.out.println("");
        System.out.print(" [ "+journey.pop()+" ] ");
        while(!journey.empty()){
            System.out.print("--> [ "+journey.pop()+" ] ");
        
        }
    }

    private void fillMinHeap() {
        for(GraphNode node: nodeList){
            minHeap.add(node);
        }
    }
}
