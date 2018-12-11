class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] newarr = new int[A.length];
        int even=0;
        int odd=A.length-1;
        for(int i=0;i<A.length;i++) {
            if(A[i]%2==0) newarr[even++] = A[i];
            else newarr[odd--] = A[i];
        }
        return newarr;
    }
}
