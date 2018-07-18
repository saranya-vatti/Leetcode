class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            int nonZeroIndex = i;
            while(nums[nonZeroIndex]!=0) {
                nonZeroIndex++;
                if(nonZeroIndex == nums.length) return;
            }
            int zeroIndex=nonZeroIndex;
            while(nums[zeroIndex] == 0) {
                zeroIndex++;
                if(zeroIndex == nums.length) return;
            }
            int tmp=nums[nonZeroIndex];
            nums[nonZeroIndex]=nums[zeroIndex];
            nums[zeroIndex]=tmp;
        }
    }
}
