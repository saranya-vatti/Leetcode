class Solution {
    boolean[] mem;
    public boolean canJump(int[] nums) {
        mem = new boolean[nums.length];
        mem[nums.length-1] = true;
        helper(nums, 0);
        return mem[0];
    }
    private boolean helper(int[] nums, int start) {
        if(start >= nums.length || mem[start]) return true;
        for(int j=1;j<=nums[start];j++) {
            mem[start] = mem[start] || helper(nums, start+j);
            if(mem[start]) {
                return true;
            }
        }
        mem[start] = false;
        return false;
    }
}
