import java.math.*;
// [2,3,2] - 4
// [2,1,1,2] - 4
// [1,2,3,4,5,6,7]
// [1,2,1,1] - 3
//[226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124]
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] maxTillNow = new int[nums.length];
        maxTillNow[0] = nums[0];
        maxTillNow[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++) {
            maxTillNow[i] = Math.max(maxTillNow[i-1], nums[i]+maxTillNow[i-2]);
        }
        return maxTillNow[nums.length - 1];
    }
}