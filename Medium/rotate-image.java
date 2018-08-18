class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length <= 1) return;
        for(int i=0;i<matrix.length;i++) {
            for(int j=i;j<matrix.length;j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        /*for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }*/
        //System.out.println();
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length/2;j++) {
                int tmp = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        /*for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }*/
    }
}
