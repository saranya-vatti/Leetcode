class Solution {
    boolean LOGGING = false;
    public boolean canReorderDoubled(int[] A) {
        if(A==null || A.length == 0) return true;
        int pairsLeft = A.length/2;
        int numZeroes = 0;
        for(int i=0;i<A.length;i++) {
            if(A[i]==0) numZeroes++;
        }
        if(numZeroes%2!=0) return false;
        pairsLeft -= numZeroes/2;
        while(pairsLeft>0) {
            log(Arrays.toString(A));
            for(int i=0;i<A.length;i++) {
                if(A[i]%2 != 0) {
                    int temp = A[i];
                    int count = 0;
                    for(int j=0;j<A.length;j++) {
                        if(A[j] == temp) {
                            A[j] = 0;
                            count++;
                        }
                    }
                    log(Arrays.toString(A));
                    int count2=0;
                    for(int j=0;j<A.length && count2<count;j++) {
                        if(A[j] == 2*temp) {
                            count2++;
                            A[j]=0;
                        }
                    }
                    log(Arrays.toString(A));
                    pairsLeft -= count;
                    if(pairsLeft<0 || count > count2) return false;
                    log("pairsLeft = " + pairsLeft);
                }
            }
            log(Arrays.toString(A));
            for(int i=0;i<A.length;i++) {
                A[i] = A[i]/2;
            }
        }
        return true;
    }
    private void log(String s) {
        if(LOGGING) {
            System.out.println(s);
        }
    }
}
