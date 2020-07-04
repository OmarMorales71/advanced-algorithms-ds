
package omar.algorithms.greedy;

import java.util.PriorityQueue;

public class FractionalKnapsack {

    public static void main(String[] args){
        
        PriorityQueue<Item> ratioItems = new PriorityQueue<Item>();
        
        ratioItems.add(new Item("Item 1", 6, 6));
        ratioItems.add(new Item("Item 2", 10, 2));
        ratioItems.add(new Item("Item 3", 3, 1));
        ratioItems.add(new Item("Item 4", 5, 8));
        ratioItems.add(new Item("Item 5", 1, 3));
        ratioItems.add(new Item("Item 6", 3, 5));
        
        double knapsackCapacity = 13;
        double knapsackFilling=0;
        double generalValue=0;
        while(!ratioItems.isEmpty()){
            Item currentItem = ratioItems.poll();
            if(knapsackCapacity>=knapsackFilling+currentItem.weight){
                System.out.println(currentItem);
                knapsackFilling+=currentItem.weight;    
                generalValue+=currentItem.value;
            }else{
                
                double dif = knapsackCapacity-knapsackFilling;
                
                double frac = (1/currentItem.weight)*dif;
                
                knapsackFilling+=(currentItem.weight*frac);
                generalValue+=(currentItem.value*frac);
                System.out.println(frac +" de "+currentItem);
                break;
            }
        }
        
        System.out.println("Llenado: "+knapsackFilling + " Value: "+generalValue);
        
        
        
        
        
    }
}

class Item implements Comparable<Item>{
    double weight;
    double value;
    double ratio;
    String name;
    
    public Item(String name, double weight, double value){
        this.name=name;
        this.weight=weight;
        this.value=value;
        this.ratio=value/weight;
    }

    @Override
    public int compareTo(Item t) {
        if(this.ratio==t.ratio){
            return 0;
        }else if(this.ratio<t.ratio){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return name;
    }
    
}
