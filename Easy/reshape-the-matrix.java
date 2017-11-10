package com.company;
import java.util.*;
public class Solution {

    private static int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = nums[0].length;
        if(rows * cols != r * c) {
            return nums;
        }
        int[] linear = new int[rows*cols];
        int counter = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                linear[counter]=nums[i][j];
                counter++;
            }
        }
        System.out.println(Arrays.toString(linear));
        int[][] newArr = new int[r][c];
        for(int i=0;i<r;i++) {
            newArr[i] = new int[c];
            for(int j=0;j<c;j++) {
                newArr[i][j] = linear[i*c + j];
            }
        }
        return newArr;
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
        int r = in.nextInt();
        int c = in.nextInt();
        int[][] reshaped = matrixReshape(board, r, c);
        for(int i=0;i<reshaped.length;i++) {
            System.out.println(Arrays.toString(reshaped[i]));
        }
    }
}
s