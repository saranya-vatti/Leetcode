class Solution {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int max_till_now = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            int tmpmax = max;
            tmpmax = Math.max(max*nums[i], Math.max(min*nums[i], nums[i]));
            min = Math.min(max*nums[i], Math.min(min*nums[i], nums[i]));
            max = tmpmax;
            max_till_now = Math.max(max, max_till_now);
        }
        return max_till_now;
    }
    
}
