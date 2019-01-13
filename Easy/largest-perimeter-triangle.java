class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int s1=A.length - 1;
        int s2=A.length - 2;
        int s3=A.length - 3;
        while(s1>=0 && s2>=0 && s3>=0 && A[s2]+A[s3]<=A[s1]) {
            s1--;
            s2--;
            s3--;
        }
        return s1<0 || s2<0 || s3<0 ? 0 : A[s1]+A[s2]+A[s3];
    }
}
