class Solution {
    public boolean validMountainArray(int[] A) {
        if(A == null) return false;
        if(A.length < 3) return false;
        int i = 0;
        for(;i<A.length-1;i++) {
            if(A[i]>A[i+1]) {
                break;
            } else if(A[i] == A[i+1]) {
                return false;
            }
        }
        if(i == 0 || i == A.length-1) return false;
        for(;i<A.length-1;i++) {
            if(A[i]<=A[i+1]) return false;
        }
        return true;
    }
}
