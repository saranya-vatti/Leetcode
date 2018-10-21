class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        for(int i=0;i<ans.length;i++) {
            for(int j=0;j<ans[0].length;j++) {
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<ans.length;i++) {
            for(int j=0;j<ans[0].length;j++) {
                if(matrix[i][j] ==0) {
                    ans[i][j] = 0;
                    //System.out.println("coming from [" + i + "][" + j + "]");
                    dfs(matrix, ans, i+1, j, 't');
                    dfs(matrix, ans, i, j+1, 'l');
                    dfs(matrix, ans, i-1, j, 'b');
                    dfs(matrix, ans, i, j-1, 'r');
                }
            }
        }
        return ans;
        
    }
    private void dfs(int[][] matrix, int[][] ans, int i, int j, char from) {
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length) return;
        if(matrix[i][j] == 0) {
            ans[i][j] = 0;
        } else {
            ans[i][j] = Math.min(min(get(ans, i-1, j), get(ans, i, j-1), get(ans, i+1, j), get(ans,i, j+1)) + 1, ans[i][j]);
            //System.out.println("r = " + i+ " and c = " + j + " = " + ans[i][j]);
            if(from == 't') {
                dfs(matrix, ans, i+1, j, 't');
                dfs(matrix, ans, i, j+1, 'l');
                dfs(matrix, ans, i, j-1, 'r');
            } else if(from == 'l') {
                dfs(matrix, ans, i, j+1, 'l');
                dfs(matrix, ans, i-1, j, 'b');
            } else if(from == 'r') {
                dfs(matrix, ans, i-1, j, 'b');
                dfs(matrix, ans, i, j-1, 'r');
            } else {
                dfs(matrix, ans, i-1, j, 'b');
            }
        }
    }
    private int min(int a, int b, int c, int d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
    private int get(int[][] ans, int r, int c) {
        if(r<0 || c<0 || r>=ans.length || c>=ans[0].length) return Integer.MAX_VALUE;
        return ans[r][c];
    }
}
