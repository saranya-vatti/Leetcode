class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> twice = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index] <0) {
                twice.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        return twice;
    }
}