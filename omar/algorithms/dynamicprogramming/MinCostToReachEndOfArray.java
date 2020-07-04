package omar.algorithms.dynamicprogramming;

import java.util.Arrays;

public class MinCostToReachEndOfArray {

    public static void main(String[] args) {
        MinCostToReachEndOfArray obj = new MinCostToReachEndOfArray();
        int[][] path = new int[][]{{4, 7, 8, 6, 4}, {6, 7, 3, 9, 2}, {3, 8, 1, 2, 4}, {7, 1, 7, 3, 7}, {2, 9, 8, 9, 3}};//new int[][]{{1,2,3},{3,2,1},{2,2,3}};
        int[][] dp = new int[path.length][path[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(obj.minCostEndArray(dp, path, 0, 0));

        System.out.println(obj.minCostEndArray_BottomUp(path));
    }

    public int minCostEndArray(int[][] dp, int[][] path, int x, int y) {
        if (x >= path.length || y >= path[0].length)
            return Integer.MAX_VALUE;
        if (x == path.length - 1 && y == path[0].length - 1)
            return path[x][y];

        if (dp[x][y] == -1) {
            int path1 = minCostEndArray(dp, path, x + 1, y);
            int path2 = minCostEndArray(dp, path, x, y + 1);
            dp[x][y] = Math.min(path1, path2) + path[x][y];
        }
        return dp[x][y];
    }

    public int minCostEndArray_BottomUp(int[][] path) {
        int[][] dp = new int[path.length][path[0].length];
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = path[i][j];
                } else {
                    if (i == 0)
                        dp[i][j] = dp[i][j - 1] + path[i][j];
                    else if (j == 0)
                        dp[i][j] = dp[i - 1][j] + path[i][j];
                    else{
                        dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+path[i][j];

                    }

                }

            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
