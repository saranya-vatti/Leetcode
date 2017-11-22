// [1,2]; 2 false
// [-1,-1]; 1 true
// [1,2,1]; 1 false
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0) return false;
        if(nums.length <= 1) return false;
        if(nums[0] == nums[1]) return true;
        if(nums.length == 2) return false;
        HashSet<Integer> set = new HashSet<>(); // max size must be k
        int start = 0;
        int end = 1;
        set.add(nums[start]);
        while(start<nums.length-1) {
            if(end - start <= k && end < nums.length) {
                if(set.contains(nums[end])) return true;
                set.add(nums[end]);
                end++;
            } else {
                set.remove(nums[start]);
                start++;
            }
        }
        return false;
    }
}