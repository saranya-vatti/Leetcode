class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1, mid;
        while(lo<hi) {
            mid = (lo+hi)/2;
            if(A[mid] < A[mid+1]) lo = mid;
            else if(A[mid-1]>A[mid]) hi = mid;
            else return mid;
        }
        return -1;
    }
}
