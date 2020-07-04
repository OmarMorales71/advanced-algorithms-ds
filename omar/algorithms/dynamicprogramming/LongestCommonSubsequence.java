
package omar.algorithms.dynamicprogramming;

public class LongestCommonSubsequence {
    
    public static void main(String[] args){
        String s1 = "OmarMorales";
        String s2 = "ValeriaVargas";
        
        System.out.println(longestCommonSubsequence(s1, s2));
    }
    
    public static int longestCommonSubsequence(String s1, String s2){
        String[] as1=s1.split("");
        String[] as2=s2.split("");
        int[][] matrixSubsequence = new int[s1.length()+1][s2.length()+1];
        
        for(int i=1; i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(as1[i-1].equalsIgnoreCase(as2[j-1])){
                    matrixSubsequence[i][j]=matrixSubsequence[i-1][j-1]+1;
                }else{
                    matrixSubsequence[i][j]=Math.max(matrixSubsequence[i][j-1], matrixSubsequence[i-1][j]);
                }
            }
        }
        String ans="";
        int c=0;
        int b= s2.length();
        for(int i=0; i<=s1.length();i++){
            
            if(matrixSubsequence[i][b]>c){
                System.out.println(c);
                c=matrixSubsequence[i][b];
                ans+=as1[i-1];
            }
            
        }
        
        System.out.println(ans);
        
        
        return matrixSubsequence[s1.length()][s2.length()];
    }
}
