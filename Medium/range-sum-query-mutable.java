class NumArray {
    private int[] n;

    public NumArray(int[] nums) {
        for(int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
        }
        this.n = nums;
    }
    
    public void update(int i, int val) {
        int oldVal = n[i];
        if(i>0) oldVal -= n[i-1];
        int diff = oldVal - val;
        for(;i<n.length;i++) {
            n[i] -= diff;
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0) return n[j];
        return n[j] - n[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
