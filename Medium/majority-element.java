class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(!freqMap.containsKey(nums[i])) {
                freqMap.put(nums[i],0);
            }
            freqMap.put(nums[i], freqMap.get(nums[i])+1);
            if(freqMap.get(nums[i]) > (nums.length/2)) return nums[i];
        }
        return nums[0];
    }
}
