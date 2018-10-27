class Solution {
    int longest = 0;
    int[][] mem;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        mem = new int[matrix.length][matrix[0].length];
        for(int i=0;i<mem.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                mem[i][j] = -1;
            }
        }
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                longest = Math.max(longest, dfs(matrix, i, j, Integer.MIN_VALUE));
                /*for(int k=0;k<matrix.length;k++) {
                    System.out.println(Arrays.toString(mem[k]));
                }
                 System.out.println();*/
            }
        }
        return longest;
    }
    private int dfs(int[][] matrix, int i, int j, int prev) {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return 0;
        int curr = matrix[i][j];
        if(curr<=prev) return 0;
        if(mem[i][j] != -1) return mem[i][j];
        int right = dfs(matrix, i, j+1, curr);
        int down = dfs(matrix, i+1, j, curr);
        int up = dfs(matrix, i-1, j, curr);
        int left = dfs(matrix, i, j-1, curr);
        mem[i][j] = Math.max(right, Math.max(down, Math.max(up, left))) + 1;
        return mem[i][j];
    }
}
