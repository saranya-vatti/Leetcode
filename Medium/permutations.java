import java.util.*;
// leetcode
public class Main {

    private static void perm(List<List<Integer>> lists, List<Integer> tempList, int
            startIndex, int[] nums) {
        if (tempList.size() == nums.length) {
            lists.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                perm(lists, tempList, i + 1, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        perm(lists, new ArrayList<>(), 0, nums);
        return lists;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1,2,3,4,5,6};
        List<List<Integer>> lists = permute(arr);
        for(int i=0;i<lists.size();i++) {
            System.out.println(Arrays.toString(lists.get(i).toArray()));
        }
    }
}
