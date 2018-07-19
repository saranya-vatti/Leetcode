class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> unique = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(!freqMap.containsKey(nums[i])) {
                unique.add(nums[i]);
                freqMap.put(nums[i],0);
            }
            freqMap.put(nums[i], freqMap.get(nums[i])+1);
        }
        Collections.sort(unique, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return freqMap.get(i1) > freqMap.get(i2) ? -1 : (freqMap.get(i1) == freqMap.get(i2) ? 0 : 1);
            }
        });
        System.out.println(Arrays.toString(unique.toArray()));
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<k;i++) {
            result.add(unique.get(i));
        }
        return result;
    }
}
