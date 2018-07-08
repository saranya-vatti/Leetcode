class Solution {
    private int bin(int[] nums, int start, int end) {
        /*System.out.println("start = " + start);
        System.out.println("end = " + end);*/
        if(start<0 || end>=nums.length || end<start) return -1;
        if(start == end) return nums[start];
        int mid = (end+start)/2;
        if(nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]) {
            return nums[mid];
        }
        if(nums[mid-1] == nums[mid]) {
            if((end-mid)%2 ==0) {
                return bin(nums, start, mid-2);
            }
            return bin(nums, mid+1, end);
        }
        if((end-mid-1)%2 ==0) {
            return bin(nums, start, mid-1);
        }
        return bin(nums, mid+2, end);
    }
    public int singleNonDuplicate(int[] nums) {
        return bin(nums, 0, nums.length - 1);
    }
}