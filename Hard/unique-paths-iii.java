class Solution {
    int ways = 0;
    public int uniquePathsIII(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    dfs(grid, i-1, j);
                    dfs(grid, i, j-1);
                    dfs(grid, i+1, j);
                    dfs(grid, i, j+1);
                }
            }
        }
        return ways;
    }
    private void dfs(int[][] grid, int x, int y) {
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y] == -1 || grid[x][y] == 1) {
            return;
        }
        if(grid[x][y] == 2) {
            boolean isDone = true;
            for(int i=0;i<grid.length;i++) {
                for(int j=0;j<grid[0].length;j++) {
                    if(grid[i][j] == 0) {
                        isDone = false;
                        break;
                    }
                }
            }
            if(isDone) {
                ways++;
            }
        }
        int[][] newgrid = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                newgrid[i][j] = grid[i][j];
            }
        }
        newgrid[x][y] = -1;
        dfs(newgrid, x+1, y);
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                newgrid[i][j] = grid[i][j];
            }
        }
        newgrid[x][y] = -1;
        dfs(newgrid, x, y+1);
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                newgrid[i][j] = grid[i][j];
            }
        }
        newgrid[x][y] = -1;
        dfs(newgrid, x-1, y);
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                newgrid[i][j] = grid[i][j];
            }
        }
        newgrid[x][y] = -1;
        dfs(newgrid, x, y-1);
    }
}
