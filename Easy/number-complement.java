package com.company;
import java.util.*;
public class Solution {
    public static int findComplement(int num) {
        int count=0;
        int result =0;
        while(num!=0) {
            if (num%2 == 0) {
                result = result + (int)Math.pow(2, count);
            }
            count++;
            num=num/2;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(findComplement(1));
    }
}
