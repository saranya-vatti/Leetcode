class Solution {
    int[][] result;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0]==1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] ==1) return 0;
        result = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<result.length;i++) {
            for(int j=0;j<result[0].length;j++) {
                
                if(obstacleGrid[i][j]==1) result[i][j]=0;
                else result[i][j] = -1;
            }
        }
        result[0][0] = 1;
        return rec(obstacleGrid, result.length-1, result[0].length-1);
    }
    private int rec(int[][] obstacleGrid, int row, int col) {
        if(row<0 || col <0) {
            return 0;
        }
        if(result[row][col] != -1) return result[row][col];
        result[row][col]=rec(obstacleGrid, row, col-1) + rec(obstacleGrid, row-1, col);
        // for(int i=0;i<result.length;i++) {
        //     System.out.println(Arrays.toString(result[i]));
        // }
        // System.out.println();
        return result[row][col];
    }
}
