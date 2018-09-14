class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        return helper(nums, 0, nums.length-1);
        
    }
    private int helper(int[] nums, int start, int end) {
        if(start >= end) return start;
        if(end == start+1) {
            if(nums[end] > nums[start]) return end;
            return start;
        }
        int mid = (start+end)/2;
        if(nums[mid]>nums[mid-1]) {
            if(nums[mid] > nums[mid+1]) return mid;
            return helper(nums, mid+1, end);
        }
        return helper(nums, start, mid-1);
    }
}
