package com.company;
import java.util.*;
public class Solution {

    private static int countN(int n) {
        HashMap<Integer, ArrayList<Integer>> possiblePositions = new HashMap<>();
        int MAX = 15;
        int[] primes = {1,2,3,5,7,11,13};
        for(int i=0;i<primes.length;i++) {
            for(int num=primes[i];num<=MAX;num=num+primes[i]) {
                if(!possiblePositions.containsKey(primes[i])) {
                    possiblePositions.put(primes[i], new ArrayList<Integer>());
                }
                possiblePositions.get(primes[i]).add(num);
                if(num>primes[i]) {
                    if(!possiblePositions.containsKey(num)) {
                        possiblePositions.put(num, new ArrayList<Integer>());
                    }
                    possiblePositions.get(num).add(primes[i]);
                }
            }
        }
        for(int i=1;i<=MAX;i++) {
            System.out.print(i + " : ");
            System.out.println(Arrays.toString(possiblePositions.get(i).toArray()));
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(countN(15));
    }
}
