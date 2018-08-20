class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length<=1) return nums.length;
        int curr = 0;
        int next = 1;
        while(next<nums.length) {
            while(nums[next] == nums[curr]) {
                next++;
                if(next==nums.length) return curr+1;
            }
            curr++;
            nums[curr] = nums[next];
        }
        return curr+1;
    }
}
