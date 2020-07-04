package omar.algorithms.dynamicprogramming;

public class HouseThief {

    public static void main(String[] args) {
        HouseThief obj = new HouseThief();
        int[] houseWorth = new int[] {20,3,15,5,4};
        System.out.println(obj.houseThief_TopDown(new int[houseWorth.length], houseWorth, 0));
        
        System.out.println(obj.houseThief_BottomUp( houseWorth, 0));
        
    }

    public int houseThief_TopDown(int[] dp, int[] houseWorth, int index) {
        if (index >= houseWorth.length) {
            return 0;
        }
        if (dp[index] == 0) {

            int stealHouse = houseWorth[index] + houseThief_TopDown(dp,houseWorth, index + 2);
            int skipHouse = houseThief_TopDown(dp,houseWorth, index + 1);
            
            dp[index]=Math.max(stealHouse, skipHouse);
        }
        return dp[index];
    }
    
    public int houseThief_BottomUp(int[] houseWorth, int index) {
        int sum=0;
        for(int i=0;i<houseWorth.length-2;){
            int steal = houseWorth[i]+houseWorth[i+2];
            int skip = houseWorth[i+1];
            if(steal>skip){
                sum+=houseWorth[i];
                
                i+=2;
                if(i>=houseWorth.length-2)
                    sum+=houseWorth[i];
            }else{
                sum+=houseWorth[i+1];
                i++;
            }
        }
        return sum;
    }
    
}
