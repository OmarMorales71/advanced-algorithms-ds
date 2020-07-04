
package omar.algorithms.nodos;

import java.util.ArrayList;
import java.util.HashMap;
import omar.algorithms.disjointSet.DisjointSet;

public class GraphNode implements Comparable<GraphNode>{

    private String name;
    private int index;
    private int distance;
    private boolean isVisited = false;
    private ArrayList<GraphNode> neighbours = new ArrayList<GraphNode>();
    private HashMap<GraphNode, Integer> neighboursWeight = new HashMap<GraphNode,Integer>();
    private GraphNode parent=null;
    private DisjointSet set;

    public DisjointSet getSet() {
        return set;
    }

    public void setSet(DisjointSet set) {
        this.set = set;
    }
    
    public GraphNode(String name, int index){
        this.name=name;
        this.index=index;
        distance = Integer.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public ArrayList<GraphNode> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<GraphNode> neighbours) {
        this.neighbours = neighbours;
    }

    public GraphNode getParent() {
        return parent;
    }

    public void setParent(GraphNode parent) {
        this.parent = parent;
    }

    public HashMap<GraphNode, Integer> getNeighboursWeight() {
        return neighboursWeight;
    }

    public void setNeighboursWeight(HashMap<GraphNode, Integer> neighboursWeight) {
        this.neighboursWeight = neighboursWeight;
    }
    
    

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(GraphNode t) {
    return this.distance-t.distance;
    }
    
    
}
