class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++) {
            nums[(nums[i]%(n+1)) -1]+=n+1;
        }
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<n;i++) {
            if(nums[i]<=n) list.add(i+1);
        }
        return list;
    }
}
