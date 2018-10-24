class NumMatrix {
    int[][] s;
    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0) {
            s = new int[0][0];
            return;
        }
        s = new int[matrix.length][matrix[0].length];
        s[0][0] = matrix[0][0];
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(i==0 && j==0) {
                    s[i][j] = matrix[0][0];
                } else if(i==0) {
                    s[i][j] = matrix[i][j] + s[i][j-1];
                } else if(j==0) {
                    s[i][j] = matrix[i][j] + s[i-1][j];
                } else {
                    s[i][j] = matrix[i][j] + s[i-1][j] + s[i][j-1] - s[i-1][j-1];
                }
            }
        }
        /*for(int i=0;i<s.length;i++) {
            System.out.println(Arrays.toString(s[i]));
        }*/
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = s[row2][col2];
        if(col1 == 0 && row1 == 0) {
            return sum;
        } else if(col1 == 0) {
            return sum - s[row1-1][col2];
        } else if(row1 == 0) {
            return sum - s[row2][col1-1];
        }
        return sum - s[row1-1][col2] - s[row2][col1-1] + s[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
