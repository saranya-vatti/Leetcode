class Solution {
    public void solve(char[][] grid) {
        if(grid == null || grid.length == 0) return;
        int row=0;
        int col=0;
        for(col=0;col<grid[0].length;col++) {
            if(grid[row][col] == 'O') {
                dfs(grid, row, col);
            }
    }
        col=grid[0].length-1;
        for(row=1;row<grid.length;row++) {
            if(grid[row][col] == 'O') {
                dfs(grid, row, col);
            }
    }
        row=grid.length-1;
        for(col=0;col<grid[0].length-1;col++) {
            if(grid[row][col] == 'O') {
                dfs(grid, row, col);
            }
    }
        col=0;
        for(row=1;row<grid.length-1;row++) {
            if(grid[row][col] == 'O') {
                dfs(grid, row, col);
            }
    }
        /*for(int i=0;i<grid.length;i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println();*/
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
                if(grid[i][j] == '+') {
                    grid[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '+' || grid[row][col] == 'X') {
            return;
        }
        grid[row][col] = '+';
        dfs(grid, row+1, col);
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row, col-1);
    }
}
