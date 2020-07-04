/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar.algorithms.dynamicprogramming;

/**
 *
 * @author kikir
 */
public class Knapsack_1_0 {

    public static void main(String[] args) {
        System.out.println(knapsackTopDown(new int[3][9], new int[]{5, 3, 4}, new int[]{2, 3, 1}, 2, 7));
        
        System.out.println(knapsackBottomUp( new int[]{5, 3, 4}, new int[]{2, 3, 1}, 7));
    }

    public static int knapsackTopDown(int[][] dp, int[] weight, int[] values, int index, int capacty) {
        if (index < 0 || capacty < 1) {
            return 0;
        }

        if (dp[index][capacty] == 0) {
            int profit1 = 0;
            if (weight[index] <= capacty) {
                profit1 = values[index] + knapsackTopDown(dp, weight, values, index - 1, capacty - weight[index]);

            }
            int profit2 = knapsackTopDown(dp, weight, values, index - 1, capacty);
            dp[index][capacty]=Math.max(profit1, profit2);
        }

        return dp[index][capacty];

    }
    
    public static int knapsackBottomUp(int[] weight, int[] values, int capacty) {
        int[][] ans  =new int[weight.length+1][capacty+1];
        
        for(int i=1;i<ans.length;i++){
            for(int j=1;j<ans[0].length;j++){
            
                if(j<weight[i-1]){
                    ans[i][j]=0;
                }else{
                    ans[i][j]=Math.max(values[i-1]+ans[i-1][j-weight[i-1]], ans[i-1][j]);
                }
            }
        }
        
        return ans[ans.length-1][ans[0].length-1];

    }
}
