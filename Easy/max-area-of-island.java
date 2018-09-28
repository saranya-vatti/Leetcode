class Solution {
    int maxArea = 0;
    int currentArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                    if(currentArea>maxArea) maxArea = currentArea;
                    currentArea = 0;
                }
            }
        }
        return maxArea;
    }
    private void dfs(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        currentArea++;
        grid[row][col] = 0;
        dfs(grid, row+1, col);
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row, col-1);
    }
}
