
package omar.algorithms.dynamicprogramming;


public class NumberFactor {
    public static void main(String[] args){
        //System.out.println(new NumberFactor().topDown(new int[100],7));
        
         System.out.println(new NumberFactor().bottomUp(7));
    }
    
    public int topDown(int[] dp, int n){
        if(n==0 || n==1 || n==2) return 1;
        
        if(n==3) return 2;
        
        if(dp[n]==0){
            
            int subfract1 = topDown(dp,n-1);
            int subfract3 = topDown(dp,n-3);
            int subfract4 = topDown(dp,n-4);
            
            dp[n]=subfract1+subfract3+subfract4;
        }
        return dp[n];
    }
    
    public int bottomUp(int n){
        int[] dp = new int[100];
        dp[0]=dp[1]=dp[2]=1;
        
        dp[3]=2;
        
        for(int i=4;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-3]+dp[i-4];
        }
        
        return dp[n];
    }
    
}
