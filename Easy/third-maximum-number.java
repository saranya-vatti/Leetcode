class Solution {
    public int thirdMax(int[] nums) {
        int thirdGreatest;
        int secondGreatest;
        int greatest;
        Set<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        
        Queue<Integer> pq = new PriorityQueue<>(set.size(), Collections.reverseOrder());
        for(int num: set) {
            pq.add(num);
        }
        if(pq.size() < 3) return pq.poll();
        for(int i=3;i>1;i--) {
            pq.poll();
        }
        return pq.poll();
    }
}
