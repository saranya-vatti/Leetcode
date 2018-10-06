class Solution {
    public boolean canJump(int[] nums) {
        int maxYouCanReach=0;
        for(int i=0;i<nums.length;i++) {
            if(i>maxYouCanReach) return false;
            maxYouCanReach = Math.max(maxYouCanReach, i+nums[i]);
        }
        return true;
        /*int start = 0;
        int end = nums[start];
        while(end<nums.length) {
            for(;start<=end && start<nums.length;start++) {
                end = Math.max(end, start+nums[start]);
            }
            if(end>=nums.length-1) return true;
            if(nums[end] == 0) return false;
        }
        return true;*/
    }
}
