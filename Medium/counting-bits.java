class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        ans[0]=0;
        if(n==0) return ans;
        ans[1]=1;
        if(n==1) return ans;
        ans[2]=1;
        for(int i=3;i<ans.length;i++) {
            ans[i] = ans[i/2];
            if(i%2==1) ans[i]++;
        }
        return ans;
    }
}
