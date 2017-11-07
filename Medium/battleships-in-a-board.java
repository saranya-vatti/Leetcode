package com.company;
import java.util.*;
/*
3 4
X..X
...X
...X
 */
public class Solution {
    public static int countBattleships(char[][] board) {
        int count=0;
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                boolean isLeftDot = j == 0 || board[i][j-1]=='.';
                boolean isTopDot = i == 0 || board[i-1][j]=='.';
                boolean isRightDot = j==col-1 || board[i][j+1] == '.';
                boolean isDownDot = i==row-1 || board[i+1][j] == '.';
                boolean isCurrX = board[i][j] == 'X';
                if(isCurrX && isLeftDot && isTopDot && (isRightDot || isDownDot)) {
                    System.out.println("i = " + i + " and  j = " + j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        String[] ships = new String[row];
        char[][] board = new char[row][col];
        for(int i=0;i<row;i++) {
            ships[i] = in.next();
            board[i] = ships[i].toCharArray();
        }
        System.out.println(countBattleships(board));
    }
}
