import java.math.*;
class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return 0;
        int cols = matrix[0].length;
        if(cols == 0) return 0;
        int[][] max = new int[rows+1][cols+1];
        max[0][0] = 0;
        int result = 0;
        if(matrix[0][0] == '1') max[0][0] = 1;
        for(int i=1;i<=rows;i++) {
            for(int j=1;j<=cols;j++) {
                if(matrix[i-1][j-1] == '1') {
                    max[i][j] = Math.min(max[i-1][j],Math.min(max[i][j-1], max[i-1][j-1]))+1;
                    if(max[i][j]>result) result = max[i][j];
                }
            }
        }
        return result*result;
    }
}
