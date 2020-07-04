package omar.algorithms.dynamicprogramming;

public class NumberOfPathsToReachLastCellWithGivenCost {

    public static void main(String[] args) {
        NumberOfPathsToReachLastCellWithGivenCost obj = new NumberOfPathsToReachLastCellWithGivenCost();

        int[][] path = new int[][]{{4,7,1,6},{5,7,3,9},{3,2,1,2},{7,1,6,3}};
        System.out.println(obj.numberOfPaths(path, path.length-1, path[0].length-1,25));
    }

    public int numberOfPaths(int[][] path, int row, int col, int cost){
        if(cost<0)
            return 0;
        if(row==0 && col==0) {
            return ((cost - path[0][0]) == 0) ? 1 : 0;
        }if(row == 0){
            return numberOfPaths(path, row, col-1, cost-path[row][col]);
        }else if(col == 0){
            return numberOfPaths(path,row-1, col,cost-path[row][col]);
        }

        int pathUp = numberOfPaths(path, row-1,col,cost-path[row][col]);
        int pathLeft = numberOfPaths(path, row,col-1,cost-path[row][col]);

        return pathLeft + pathUp;
    }
}
