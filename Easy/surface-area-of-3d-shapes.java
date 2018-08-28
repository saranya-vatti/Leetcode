class Solution {
    public int surfaceArea(int[][] grid) {
        int area = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                int left = 0, top = 0, right = 0, up = grid[i][j]>0 ? 1 : 0, bottom = 0, down = grid[i][j]>0 ? 1 : 0;
                if(j==0) {
                    left = grid[i][j];
                } else {
                    if(grid[i][j-1]<grid[i][j]) {
                        left = grid[i][j] - grid[i][j-1];
                    }
                }
                if(i==0) {
                    top = grid[i][j];
                } else {
                    if(grid[i-1][j]<grid[i][j]) {
                        top = grid[i][j] - grid[i-1][j];
                    }
                }
                if(j==grid[i].length-1) {
                    right = grid[i][j];
                } else {
                    if(grid[i][j+1]<grid[i][j]) {
                        right = grid[i][j] - grid[i][j+1];
                    }
                }
                if(i==grid.length-1) {
                    bottom = grid[i][j];
                } else {
                    if(grid[i+1][j]<grid[i][j]) {
                        bottom = grid[i][j] - grid[i+1][j];
                    }
                }
                area += left + top + right + up + bottom + down;
            }
        }
        return area;
    }
}
