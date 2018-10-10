class Solution {
    public int[][] floodFill(int[][] grid, int row, int col, int newColor) {
        int oldColor = grid[row][col];
        dfs(grid, row, col, newColor, oldColor);
        return grid;
    }
    private void dfs(int[][] grid, int row, int col, int newColor, int oldColor) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != oldColor || grid[row][col] == newColor) {
            return;
        }
        grid[row][col] = newColor;
        dfs(grid, row+1, col,newColor, oldColor);
        dfs(grid, row, col+1, newColor, oldColor);
        dfs(grid, row-1, col, newColor, oldColor);
        dfs(grid, row, col-1, newColor, oldColor);
    }
}
