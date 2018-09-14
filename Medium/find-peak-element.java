class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        return helper(nums, 0, nums.length-1);
        
    }
    private int helper(int[] nums, int start, int end) {
        if(start == end) return start;
        if(nums[start+1] < nums[start]) return start;
        if(nums[end] > nums[end-1]) return end;
        return helper(nums, start+1, end-1);
    }
}
