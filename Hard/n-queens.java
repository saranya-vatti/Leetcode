class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = '.';
            }

        }
        rec(n, 0, arr);
        return ans;
    }
    private void rec(int n, int row, char[][] array) {
        if(row == n) {
            List<String> newAns = new ArrayList<>();
            for(int i=0;i<n;i++) {
                StringBuilder str = new StringBuilder();
                for(int j=0;j<n;j++) {
                    if(array[i][j] == '-') str.append('.');
                    else str.append(array[i][j]);
                }
                newAns.add(str.toString());
            }
            ans.add(newAns);
            return;
        }
        
        for(int j=0;j<n;j++) {
            if(array[row][j] != '-') {  
                char[][] arr = deepCopy(array);
                //same col, all rows
                for(int r=0;r<n;r++) {
                    arr[r][j] = '-';
                }
                //same row, all col
                for(int c=0;c<n;c++) {
                    arr[row][c] = '-';
                }
                markTopLeftDiag(arr, row, j);
                markBottomLeftDiag(arr, row, j);
                markTopRightDiag(arr, row, j);
                markBottomRightDiag(arr, row, j);
                arr[row][j] = 'Q';
                rec(n, row+1, arr);
            }
        }
    }
    private void markTopLeftDiag(char[][] arr, int row, int col) {
        if(0<= row && row < arr.length && 0<=col && col<arr.length) {
            arr[row][col] = '-';
            markTopLeftDiag(arr, row-1, col-1);
        }
    }
    private void markBottomLeftDiag(char[][] arr, int row, int col) {
        if(0<= row && row < arr.length && 0<=col && col<arr.length) {
            arr[row][col] = '-';
            markBottomLeftDiag(arr, row+1, col-1);
        }
    }
    private void markTopRightDiag(char[][] arr, int row, int col) {
        if(0<= row && row < arr.length && 0<=col && col<arr.length) {
            arr[row][col] = '-';
            markTopRightDiag(arr, row-1, col+1);
        }
    }
    private void markBottomRightDiag(char[][] arr, int row, int col) {
        if(0<= row && row < arr.length && 0<=col && col<arr.length) {
            arr[row][col] = '-';
            markBottomRightDiag(arr, row+1, col+1);
        }
    }
    public char[][] deepCopy(char[][] input) {
        char[][] result = new char[input.length][input.length];
        for (int r = 0; r < input.length; r++) {
            result[r] = input[r].clone();
        }
        return result;
    }
}
