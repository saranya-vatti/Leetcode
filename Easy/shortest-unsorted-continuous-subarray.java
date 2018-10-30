class Solution {
    // [1,3,2,2,2]
    // 4
    // [2,6,4,8,10,9,15]
    // 5
    // [2,3,3,2,4]
    // 3
    // [1,2,4,5,3]
    // 3
    // [1,3,5,2,4]
    // 4
    public int findUnsortedSubarray(int[] nums) {
        int firstIndex = nums.length;
        int lastIndex = -1;
        int[] sorted = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted);
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != sorted[i]) {
                firstIndex = Math.min(firstIndex, i);
                lastIndex = Math.max(lastIndex, i);
            }
        }
        return lastIndex < 0 ? 0 : lastIndex - firstIndex + 1;
    }
}
