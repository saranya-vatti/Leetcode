class Solution {
    int sum;
    int count = 0;
    
    public int findTargetSumWays(int[] nums, int S) {
        sum = S;
        dp(nums, 0, 0);
        return count;
    }
    private void dp(int[] nums, int start, int sumTillNow) {
        if(start == nums.length) {
            if(sumTillNow == sum) {
                count++;
            }
            return;
        }
        dp(nums, start+1, nums[start]+sumTillNow);
        dp(nums, start+1, -nums[start]+sumTillNow);
    }
}
