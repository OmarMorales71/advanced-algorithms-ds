/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.divideandconquer;

/**
 *
 * @author kikir
 */
public class FibonacciSerie {
    public static void main(String[] args){
        FibonacciSerie serie= new FibonacciSerie();
        
        System.out.println(serie.fibonacci(100));
    }
    
    public int fibonacci(int n){
        if(n<1)return -1;
        
        if(n==1)return 0;
        if(n==2)return 1;
        
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
