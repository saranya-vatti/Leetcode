class Solution {
    public boolean lemonadeChange(int[] bills) {
        int have5 = 0, have10 = 0;
        for(int i=0;i<bills.length;i++) {
            if(bills[i]==10) {
                have10++;
                have5--;
            }
            if(bills[i]==20) {
                have5--;
                if(have10==0) {
                    have5-=2;
                } else {
                    have10--;
                }
            }
            if(bills[i]==5) {
                have5++;
            }
            if(have5<0 || have10<0) return false;
            
        }
        return true;
    }
}
