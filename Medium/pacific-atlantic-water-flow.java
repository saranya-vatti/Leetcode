class Solution {
    boolean at, pac;
    List<int[]> list;
    boolean[][] marked;
    int R; int C;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        list = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return list;
        R = matrix.length;
        C = matrix[0].length;
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                at = false;
                pac = false;
                marked = new boolean[R][C];
                //System.out.println("Starting from [" + i + "][" + j + "] = " + matrix[i][j]);
                if(dfs(matrix, i, j, matrix[i][j])) {
                    list.add(new int[]{i, j});
                }
            }
        }
        return list;
    }
    private boolean dfs(int[][] matrix, int i, int j, int prev) {
        if(i<0 || j<0 || i>=R || j>=C) return at&&pac;
        int curr = matrix[i][j];
        if(curr > prev || marked[i][j]) return pac&&at;
        //System.out.println("going to [" + i + "][" + j + "] = " + matrix[i][j]);
        marked[i][j] = true;
        prev = matrix[i][j];
        if(i==0 || j==0) {
            pac = true;
        }
        if(i==R-1 || j==C-1 ) {
            at = true;
        }
        if(at&&pac) {
            return true;
        }
        return (dfs(matrix, i-1, j, curr) || dfs(matrix, i, j-1, curr) || dfs(matrix, i, j+1, curr) || dfs(matrix, i+1, j, curr));
    }
}
