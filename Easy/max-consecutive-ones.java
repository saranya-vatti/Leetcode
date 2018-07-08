// [1,0,1,1,0,1] - 2
// [1,1,0,1,1,1] - 3
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0;
        int j=0;
        int max = 0;
        while(i<nums.length) {
            while(i<nums.length && nums[i] == 0) i++;
            j = i+1;
            while(i<nums.length && j<nums.length && nums[j]==1) j++;
            if(i<nums.length && j-i > max) max = j-i;
            i=j+1;
        }
        return max;
    }
}