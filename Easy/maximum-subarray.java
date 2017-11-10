package com.company;
import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int a1 = 0; a1 < n; a1++){
            nums[a1] = in.nextInt();
        }
        int maxWithLast = nums[0];
        int maxOverall = nums[0];
        for(int i=1;i<nums.length;i++) {
            maxWithLast = Math.max(nums[i], maxWithLast+nums[i]);
            maxOverall = Math.max(maxOverall, maxWithLast);
        }
        System.out.println(maxOverall);
        in.close();
    }
}
