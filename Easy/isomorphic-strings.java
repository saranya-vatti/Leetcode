package com.company;
import java.util.*;
public class Solution {
    private static boolean isIsomorphic(String s, String t) {
        s = s.replace("\\", "");
        t = t.replace("\\", "");
        HashMap<Character, Character> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        HashMap<Character, Integer> sfreq = new HashMap<>();
        HashMap<Character, Integer> tfreq = new HashMap<>();
        for(int i=0;i<sArr.length;i++) {
            if(sfreq.containsKey(sArr[i])) {
                sfreq.put(sArr[i], sfreq.get(sArr[i]) + 1);
            } else {
                sfreq.put(sArr[i], 1);
            }
            if(tfreq.containsKey(tArr[i])) {
                tfreq.put(tArr[i], tfreq.get(tArr[i]) + 1);
            } else {
                tfreq.put(tArr[i], 1);
            }
        }
        for(int i=0;i<sArr.length;i++) {
            if(map.containsKey(sArr[i])) {
                if(map.get(sArr[i]) != tArr[i]) {
                    System.out.printf("1 %s != %s\n", map.get(sArr[i]), tArr[i]);
                    return false;
                }
            } else {
                if(!sfreq.get(sArr[i]).equals(tfreq.get(tArr[i]))) {
                    System.out.printf("2 %d != %d\n", sfreq.get(sArr[i]), tfreq.get
                            (tArr[i]));
                    System.out.printf("3 %c != %c\n", sArr[i], tArr[i]);
                    return false;
                }
                map.put(sArr[i], tArr[i]);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(isIsomorphic(in.nextLine(), in.nextLine()));
    }
}
