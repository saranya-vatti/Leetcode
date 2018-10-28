class Solution {
    public int minFallingPathSum(int[][] A) {
        int minPath = Integer.MAX_VALUE;
        for(int i=1;i<A.length;i++) {
            for(int j=0;j<A[0].length;j++) {
                if(j==0) {
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
                } else if(j==A[0].length-1) {
                    A[i][j] += Math.min(A[i-1][j-1], A[i-1][j]);
                } else {
                    A[i][j] += Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));
                }
            }
        }
        for(int col=0;col<A[0].length;col++) {
            minPath = Math.min(minPath, A[A.length-1][col]);
        }
        return minPath;
    }
}
