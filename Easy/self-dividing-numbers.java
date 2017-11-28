class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res= new ArrayList<>();
        for(int i=left;i<=right;i++) {
            int n = i;
            boolean isSelfDiv = true;
            while(n>0) {
                if(n%10 == 0 || i % (n%10) != 0) isSelfDiv = false;
                n=n/10;
            }
            if(isSelfDiv) res.add(i);
        }
        return res;
    }
}