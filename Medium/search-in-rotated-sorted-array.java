// [4,5,6,7,0,1,2], 6 : 2
// [4,5,6,7,0,1,2], 5 : 1
// [1,3], 2 : -1
class Solution {
    private int helper(int[] nums, int start, int end, int target) {
        //System.out.printf("Searching from %d (%d) to %d (%d) for %d\n", start, nums[start], end, nums[end], target);
        if(nums.length == 0 || start < 0 || end > nums.length-1 || end <start) return -1;
        if(nums[end] == target) return end;
        if(nums[start] == target) return start;
        int mid = (start + end) / 2;
        if(nums[mid] == target) return mid;
        int s = nums[start];
        int e = nums[end];
        int m = nums[mid];
        int t = target;
        if((s<t && t<m) || (m<s && s<t) || (t<m && m<s)) {
            return helper(nums, start+1, mid-1, target);
        }
        if ((m<t && t<e) || (e<m && m<t) || (t<e && e<m)) {
            return helper(nums, mid+1, end-1, target);
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length-1, target);
    }
}