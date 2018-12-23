class Solution {
    public int repeatedNTimes(int[] A) {
        int[] arr = new int[10000];
        for(int i=0;i<A.length;i++) {
            if(arr[A[i]]>0) return A[i];
            arr[A[i]] = 1;
        }
        return 0;
    }
}
