class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1) return nums;
        if(nums.length == 2) {
            int tmp = nums[1];
            nums[1] = nums[0];
            nums[0] = tmp;
            return nums;
        }
        int[] leftToRight = new int[nums.length];
        int[] rightToLeft = new int[nums.length];
        leftToRight[0] = 1;
        leftToRight[1] = nums[0];
        rightToLeft[nums.length - 1] = 1;
        rightToLeft[nums.length - 2] = nums[nums.length - 1];
        for(int i=2;i<nums.length;i++) {
            leftToRight[i] = leftToRight[i-1] * nums[i-1];
        }
        for(int i=nums.length - 3;i>=0;i--) {
            rightToLeft[i] = rightToLeft[i+1] * nums[i+1];
        }
        for(int i=0;i<nums.length;i++) {
            nums[i] = leftToRight[i] * rightToLeft[i];
        }
        return nums;
    }
}