
import java.io.*;
import java.util.*;
public class Main {
    private static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        int total = 0;
        HashSet<Integer> setA = new HashSet<>();
        for(int i=0;i<nums1.length;i++) {
            setA.add(nums1[i]);
        }
        HashSet<Integer> setB = new HashSet<>();
        for(int i=0;i<nums2.length;i++) {
            setB.add(nums2[i]);
        }
        for(int elem:setA) {
            if(setB.contains(elem)) res.add(elem);
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return  resArr;
    }
    public static void main(String[] args) throws IOException {
        int[] arr1 = {1,1,2,2,2,3};
        int[] arr2 = {1,2,2,3};
        System.out.println(Arrays.toString(intersection(arr1, arr2)));
    }
}
