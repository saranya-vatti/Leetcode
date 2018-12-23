class Solution {
    public int maxWidthRamp(int[] A) {
        int minStartVal = 50001;
        int diff = 0;
        for(int i=0;i<A.length;i++) {
            if(minStartVal>=A[i]) {
                for(int j=A.length-1;j>i;j--) {
                    if(A[j] >= A[i]) {
                        minStartVal = A[i];
                        diff = Math.max(diff, j-i);
                        break;
                    }
                }
            }
            // System.out.println("minStartVal = " + minStartVal);
            // System.out.println("diff = " + diff);
        }
        return diff;
    }
}
