package omar.algorithms.dynamicprogramming;

public class LongestCommonSubstring {

    public static void main(String args[]) {
        String s1 = "LomitosBonitos";
        String s2 = "GatitosBuapos";

        longestCommonSubstring(s1, s2);

    }

    private static void longestCommonSubstring(String s1, String s2) {
        String[] as1 = s1.split("");
        String[] as2 = s2.split("");

        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        int x=0, y=0;
        int max=0;
        for (int i = 1; i <= as1.length; i++) {
            for (int j = 1; j <= as2.length; j++) {
                if(as1[i-1].equalsIgnoreCase(as2[j-1])){
                    matrix[i][j]=matrix[i-1][j-1]+1;
                    if(matrix[i][j]>max){
                        max=matrix[i][j];
                        x=i;
                        y=j;
                    }
                }
            }
        }
        
        if(max!=0){
            String[] ans=new String[max];
            while(max!=0){
                ans[max-1]=as1[x-1];
                max--;x--;
            }
            
            String res= "";
            
            for(String letter: ans){
                res+=letter;
            }
            
            
            System.out.println("substring: "+res+ " length: "+res.length());
        }else{
            System.out.println("No substring");
        }
    }
}
