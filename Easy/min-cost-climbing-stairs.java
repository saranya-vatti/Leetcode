class Solution {
    int[] memoization;
    public int minCostClimbingStairs(int[] cost) {
        memoization = new int[cost.length];
        for(int i=0;i<cost.length;i++) {
            memoization[i] = -1;
        }
        return Math.min(helper(cost, 0), helper(cost, 1));
    }
    private int helper(int[] cost, int startIndex) {
        if(startIndex >= cost.length) return 0;
        if(memoization[startIndex] != -1) return memoization[startIndex];
        int ans;
        if(startIndex == cost.length-1) ans = cost[startIndex];
        else ans = cost[startIndex] + Math.min(helper(cost, startIndex+1), helper(cost, startIndex+2));
        memoization[startIndex] = ans;
        return ans;
    }
}
