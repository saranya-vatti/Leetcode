class Solution {;
    public int[] diStringMatch(String S) {
        int min = 0;
        int[] ans = new int[S.length()+1];
        HashSet<Integer> set = new HashSet<>();
        ans[0] = 0;
        set.add(0);
        for(int i=1;i<ans.length;i++) {
            if(S.charAt(i-1) == 'I') {
                int poss = ans[i-1]+1;
                while(set.contains(poss)) poss++;
                ans[i] = poss;
                set.add(poss);
            } else {
                int poss = ans[i-1]-1;
                while(set.contains(poss)) poss--;
                ans[i] = poss;
                set.add(poss);
            }
            if(min>ans[i]) min = ans[i];
        }
        for(int i =0;i<ans.length;i++) {
            ans[i]=ans[i]-min;
        }
        return ans;
    }
}
