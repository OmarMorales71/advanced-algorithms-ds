package omar.algorithms.dynamicprogramming;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s = "sdgajsdghajshdfajshd";
        int[][] dp = new int[s.length()][s.length()];
        
        System.out.println(lps_TopDown(dp, s.toLowerCase(), 0, s.length() - 1));
        System.out.println(lps_BottomUp(s.toLowerCase()));
    }

    public static int lps_TopDown(int[][] dp, String s, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return 0;
        } else if (beginIndex == endIndex) {
            return 1;
        }

        if (dp[beginIndex][endIndex] == 0) {
            int count1 = 0;
            if (s.charAt(beginIndex) == s.charAt(endIndex)) {
                count1 = 2 + lps_TopDown(dp, s, beginIndex + 1, endIndex - 1);
            }

            int count2 = lps_TopDown(dp, s, beginIndex + 1, endIndex);
            int count3 = lps_TopDown(dp, s, beginIndex, endIndex - 1);

            dp[beginIndex][endIndex] =Math.max(count1, Math.max(count2, count3));
        }
        
        return dp[beginIndex][endIndex];

    }
    public static int lps_BottomUp(String s){
        int [][] dp = new int[s.length()][s.length()];
        
        //i=columna=endIndex  j=row=beginIndex
        for(int i=0;i<dp.length;i++){
            for(int j=i;j>=0;j--){
                if(i==j){
                    dp[i][j]=1;
                }else{
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j]=Math.max(dp[i-1][j+1]+2, Math.max(dp[i-1][j],dp[i][j+1]));
                    else
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j+1]);
                }
            }
        }
        
        return dp[dp.length-1][0];
    }
}
