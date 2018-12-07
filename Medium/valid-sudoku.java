class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[][] block = new HashSet[3][3];
        for(int i=0;i<9;i++) {
            row[i] = new HashSet<Character>();
            col[i] = new HashSet<Character>();
        }
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                block[i][j] = new HashSet<Character>();
            }
        }
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j] != '.') {
                    if(!row[i].add(board[i][j]) || !col[j].add(board[i][j]) || !block[i/3][j/3].add(board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }
}
