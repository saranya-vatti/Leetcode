package com.company;
import java.util.*;
public class Solution {
    private static int islandPerimeter(int[][] grid) {
        int count=0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                boolean isLeftEdge = j == 0 || grid[i][j - 1] == 0;
                boolean isTopEdge = i == 0 || grid[i-1][j]==0;
                boolean isRightEdge = j==col-1 || grid[i][j+1] == 0;
                boolean isDownEdge = i==row-1 || grid[i+1][j] == 0;
                boolean isCurrIsland = grid[i][j] == 1;
                if(isCurrIsland) {
                    if(isLeftEdge) count++;
                    if(isTopEdge) count++;
                    if(isRightEdge) count++;
                    if(isDownEdge) count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] board = new int[row][col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<board[i].length;j++) {
                board[i][j] = in.nextInt();
            }
        }
        System.out.println(islandPerimeter(board));
    }
}
