class Solution {
    public int rotatedDigits(int N) {
        int ans = 0;
        for(int i=1;i<=N;i++) {
            if(isGood(i)) ans++;
        }
        return ans;
    }
    private boolean isGood(int N) {
        boolean changes = false;
        while(N>0) {
            int digit = N%10;
            if(digit == 3|| digit == 4 || digit == 7) return false;
            if(digit == 2 || digit == 5 || digit == 6 || digit == 9) changes = true;
            N=N/10;
        }
        return changes;
    }
}
