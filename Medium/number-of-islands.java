class Solution {
    int islands = 0;
    public int numIslands(char[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                    //System.out.println("islands = " + islands + " at [" + i + ", " + j + "]");
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row+1, col);
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row, col-1);
    }
}
