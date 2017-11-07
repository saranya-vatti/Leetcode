package com.company;
import java.util.*;
public class Solution {
    public static List<String> fizzBuzz(int n) {
        List<String> alist = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            String num = "";
            if (i%15==0) {
                num = "FizzBuzz";
            } else if (i%3==0) {
                num = "Fizz";
            } else if (i%5==0) {
                num = "Buzz";
            } else {
                num = Integer.toString(i);
            }
            alist.add(num);
        }
        return alist;
    }
    public static void main(String[] args) {
        System.out.println(fizzBuzz(50));
    }
}
