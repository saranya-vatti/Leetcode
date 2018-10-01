class Solution {
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                int live = getLiveNeibhors(board, i, j);
                if(board[i][j] == 1) {
                    if(live < 2 || live > 3) board[i][j] = -1;
                } else {
                    if(live==3) board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]==-1) board[i][j]=0;
                if(board[i][j]==2) board[i][j]=1;
            }
        }
    }
    private int getLiveNeibhors(int[][] board, int row, int col) {
        int count = 0;
        if(row>0 && col>0 && row<board.length && col<board[0].length) {
            if(board[row-1][col-1] == 1 || board[row-1][col-1] == -1) count++;
        }
        if(row>0 && col>=0 && row<board.length && col<board[0].length) {
            if(board[row-1][col] == 1 || board[row-1][col] == -1) count++;
        }
        if(row>0 && col>=0 && row<board.length && col<board[0].length-1) {
            if(board[row-1][col+1] == 1 || board[row-1][col+1] == -1) count++;
        }
        if(row>=0 && col>=0 && row<board.length && col<board[0].length-1) {
            if(board[row][col+1] == 1 || board[row][col+1] == -1) count++;
        }
        if(row>=0 && col>=0 && row<board.length-1 && col<board[0].length-1) {
            if(board[row+1][col+1] == 1 || board[row+1][col+1] == -1) count++;
        }
        if(row>=0 && col>=0 && row<board.length-1 && col<board[0].length) {
            if(board[row+1][col] == 1 || board[row+1][col] == -1) count++;
        }
        if(row>=0 && col>0 && row<board.length-1 && col<board[0].length) {
            if(board[row+1][col-1] == 1 || board[row+1][col-1] == -1) count++;
        }
        if(row>=0 && col>0 && row<board.length && col<board[0].length) {
            if(board[row][col-1] == 1 || board[row][col-1] == -1) count++;
        }
        //System.out.println("Live neibors of [" + row + "][" + col +"] are " + count);
        return count;
    }
}
