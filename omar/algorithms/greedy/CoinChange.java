
package omar.algorithms.greedy;
public class CoinChange {
    
    public static void main(String[] args){
        int[] coins = {1,2,5,10,20,50,100,200,500,1000};
        
        int change = 12056;
        
        int minCoins=0;
        
        for(int i=coins.length-1; i>=0;i--){
            while(coins[i]<=change){
                change-=coins[i];
                minCoins++;
            }
            
            if(change==0)break;
        }
        
        System.out.println(minCoins);
    }
}
