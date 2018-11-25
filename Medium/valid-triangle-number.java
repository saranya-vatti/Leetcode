class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        if(nums == null || nums.length < 3) return 0;
        for(int i=0;i<nums.length-2;i++) {
            for(int j=i+1;j<nums.length-1;j++) {
                int index = find(nums, nums[i]+nums[j]-1);
                while(index>j) {
                    //System.out.println(nums[i] + ", " + nums[j] + ", " + nums[index]);
                    count++;
                    index--;
                }
            }
        }
        return count;
    }
    private int find(int[] arr, int num) {
        //TODO implement binary for closest num <= num
        for(int i=arr.length-1;i>=0;i--) {
            if(arr[i] <= num) return i;
        }
        return -1;
    }
}
