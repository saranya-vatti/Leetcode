class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxCol = new int[grid.length];
        int[] maxRow = new int[grid[0].length];
        for(int i=0;i<grid.length;i++) {
            int max = -1;
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]>max) max = grid[i][j];
            }
            maxRow[i] = max;   
        }
        for(int i=0;i<grid[0].length;i++) {
            int max = -1;
            for(int j=0;j<grid.length;j++) {
                if(grid[j][i]>max) max = grid[j][i];
            }
            maxCol[i] = max;
        }
        //System.out.println("maxRow : " + Arrays.toString(maxRow));
        //System.out.println("maxCol : " + Arrays.toString(maxCol));
        int sum = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                sum+= Math.min(maxRow[i], maxCol[j]) - grid[i][j];
            }
        }
        return sum;
    }
}
