class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int sum1 = 1;
        int sum2 = 2;
        n-=2;
        while(n-->0) {
            int tmp = sum2;
            sum2 = sum1+sum2;
            sum1 = tmp;
        }
        return sum2;
    }
}
