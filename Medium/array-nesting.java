class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            int s = i;
            int count = 1;
            int j=i;
            // System.out.println("starting from " + s);
            while(nums[j] >= 0 && nums[j] != s && nums[j] != -1-s) {
                // System.out.println("j= " + j);
                nums[j] = -1 -nums[j];
                j = (nums[j]*-1) -1;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
