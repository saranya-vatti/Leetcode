class Solution {
    int[] oddMem;
    int[] evenMem;
    public int oddEvenJumps(int[] A) {
        int count = 0;
        oddMem = new int[A.length];
        evenMem = new int[A.length];
        oddMem[A.length-1] = 1;
        evenMem[A.length-1] = 1;
        for(int i=0;i<A.length;i++) {
            oddMem[i] = dp(i, A, true);
            // System.out.println(Arrays.toString(oddMem));
        }
        for(int i=0;i<oddMem.length;i++) {
            if(oddMem[i] == 1) count++;
        }
        return count;
    }
    private int dp(int index, int[] A, boolean isOdd) {
        if(isOdd && oddMem[index] != 0) return oddMem[index];
        if(!isOdd && evenMem[index] != 0) return evenMem[index];
        if(isOdd) {
            int min = 100000;
            int minIndex = -1;
            for(int i=index+1;i<A.length;i++) {
                if(A[index]<=A[i] && A[i] < min) {
                    min = A[i];
                    minIndex = i;
                }
            }
            if(minIndex == -1) {
                oddMem[index] = -1;
                // System.out.println(Arrays.toString(oddMem));
                return oddMem[index];
            }
            oddMem[index] = dp(minIndex, A, false);
            // System.out.println(Arrays.toString(oddMem));
            return oddMem[index];
        }
        int max = -1;
        int maxIndex = -1;
        for(int i=index+1;i<A.length;i++) {
            if(A[index]>=A[i] && A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
        }
        if(maxIndex == -1) {
            evenMem[index] = -1;
            // System.out.println(Arrays.toString(evenMem));
            return evenMem[index];
        }
        evenMem[index] = dp(maxIndex, A, true);
        // System.out.println(Arrays.toString(evenMem));
        return evenMem[index];
    }
}
