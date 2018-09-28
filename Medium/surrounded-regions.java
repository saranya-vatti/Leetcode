class Solution {
    public void solve(char[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 'O') {
                    if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1) {
                        dfs(grid, i, j, '+');
                    }
                }
            }
        }
        /*for(int i=0;i<grid.length;i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println();*/
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 'O') {
                    dfs(grid, i, j, 'X');
                }
            }
        }
        /*for(int i=0;i<grid.length;i++) {
            System.out.println(Arrays.toString(grid[i]));
        }*/
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == '+') {
                    grid[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] grid, int row, int col, char changeTo) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == changeTo || grid[row][col] == 'X') {
            return;
        }
        grid[row][col] = changeTo;
        dfs(grid, row+1, col, changeTo);
        dfs(grid, row, col+1, changeTo);
        dfs(grid, row-1, col, changeTo);
        dfs(grid, row, col-1, changeTo);
    }
}
