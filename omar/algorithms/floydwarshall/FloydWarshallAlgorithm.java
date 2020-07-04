/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.floydwarshall;

import java.util.Stack;

/**
 *
 * @author kikir
 */
public class FloydWarshallAlgorithm {

    static int[][] distanceTable;
    static String[][] parentTable;
    static String[] abc={"A","B","C","D","E"};
 
    public static void main(String args[]) {
        int vertices = 4;

        distanceTable = new int[vertices][vertices];
        parentTable = new String[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {

                if (i != j) {
                    distanceTable[i][j] = Integer.MAX_VALUE;
                    parentTable[i][j] =abc[j] ;
                } else {

                    parentTable[i][j] = "-";
                }
            }
        }

        addDirectedEdge(0, 1, 8);
        addDirectedEdge(0, 3, 1);
        addDirectedEdge(1, 2, 1);
        addDirectedEdge(2, 0, 4);
        addDirectedEdge(3, 2, 9);
        addDirectedEdge(3, 1, 2);

        for (int i = 0; i < vertices; i++) {
            System.out.println("");
            for (int j = 0; j < vertices; j++) {
                System.out.print(" [ " + distanceTable[i][j] + " ] ");
            }
        }
        System.out.println("\n--------------------------");

        for (int i = 0; i < vertices; i++) {
            System.out.println("");
            for (int j = 0; j < vertices; j++) {
                System.out.print(" [ " + parentTable[i][j] + " ] ");
            }
        }
        System.out.println("\n--------------------------");
        for (int via = 0; via < vertices; via++) {
            //System.out.println(via);
            for (int u = 0; u < vertices; u++) {
                //System.out.println(u);
                for (int v = 0; v < vertices; v++) {
                    //System.out.println(v);
                    if (distanceTable[u][via] != Integer.MAX_VALUE && distanceTable[via][v] != Integer.MAX_VALUE) {

                        //System.out.println("via :"+via+" u"+u+" v:"+v+" "+distanceTable[u][v].getDistance()+" "+ (distanceTable[u][via].getDistance() + distanceTable[via][v].getDistance()));
                        if (distanceTable[u][v] > distanceTable[u][via] + distanceTable[via][v]) {
                            distanceTable[u][v] = distanceTable[u][via] + distanceTable[via][v];
                            //System.out.println("Nodo a actualizar "+distanceTable[u][v]+ " Padre:"+distanceTable[u][via]);

                            //GraphNode currentParent = distanceTable[u][via];
                            parentTable[u][v] = abc[via];
                        }
                    }

                }
            }
        }
        for (int i = 0; i < vertices; i++) {
            System.out.println("");
            for (int j = 0; j < vertices; j++) {
                System.out.print(" [ " + distanceTable[i][j] + " ] ");
            }
        }
        System.out.println("\n--------------------------");
        for (int i = 0; i < vertices; i++) {
            System.out.println("");
            for (int j = 0; j < vertices; j++) {
                System.out.print(" [ " + parentTable[i][j] + " ] ");
            }
        }
        System.out.println("\n--------------------------");
         findShortestPath(2, 1);

    }

    private static void addDirectedEdge(int a, int b, int c) {
        distanceTable[a][b] = c;

    }
    private static void findShortestPath(int a, int b) {
        
        Stack<String> stack = new Stack<String>();
        
        
        System.out.println("");
        System.out.print(" [ "+abc[a]+" ] ");
        while(a!=b){
            System.out.print("-> [ "+parentTable[a][b]+" ] ");
            a=parentTable[a][b].charAt(0)-65;

        }
    }
}
