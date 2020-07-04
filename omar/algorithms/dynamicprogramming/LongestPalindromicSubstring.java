package omar.algorithms.dynamicprogramming;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String word = "mqadasm";
        int[][] dp = new int[word.length()][word.length()];
        System.out.println(longestPalindromicSubstring(dp, word, 0, word.length() - 1));
        System.out.println(longestPalindromicSubstring_BottomUp(word));
    }

    private static int longestPalindromicSubstring_BottomUp(String word) {
        int[][] dp = new int[word.length()][word.length()];

        for (int endIndex = 0; endIndex < dp.length; endIndex++) {
            for (int startIndex = endIndex; startIndex >= 0; startIndex--) {

                if (startIndex == endIndex)
                    dp[startIndex][endIndex] = 1;
                else {
                    if (word.charAt(startIndex) == word.charAt(endIndex)) {
                        int remainingLength = (endIndex - startIndex) - 1;
                        int x= (remainingLength == dp[startIndex + 1][endIndex - 1]) ? dp[startIndex + 1][endIndex - 1] + 2 : 0;
                        dp[startIndex][endIndex]=Math.max(x,Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]));
                    } else {
                        dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                    }
                }

            }
        }
        return dp[0][dp[0].length-1];
    }

    private static int longestPalindromicSubstring(int[][] dp, String s, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;
        else if (startIndex == endIndex)
            return 1;
        if (dp[startIndex][endIndex] == 0) {

            int c1 = 0;
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                int remainingLength = (endIndex - startIndex) - 1;
                if (remainingLength == longestPalindromicSubstring(dp, s, startIndex + 1, endIndex - 1))
                    c1 = remainingLength + 2;
                //c1=longestPalindromicSubstring(s,startIndex+1,endIndex-1)+2; //Longest Palindromic Subsequence
            }
            int c2 = longestPalindromicSubstring(dp, s, startIndex + 1, endIndex);
            int c3 = longestPalindromicSubstring(dp, s, startIndex, endIndex - 1);


            dp[startIndex][endIndex] = Math.max(c1, Math.max(c2, c3));
        }
        return dp[startIndex][endIndex];
    }


}
