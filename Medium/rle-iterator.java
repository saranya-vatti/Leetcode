class RLEIterator {
    int[] arr;
    int firstNonZero;

    public RLEIterator(int[] A) {
        arr = A;
        for(int i=0;i<A.length;i+=2) {
            if(A[i] != 0) {
                firstNonZero = i;
                break;
            }
        }
    }
    
    public int next(int n) {
        System.out.println("next called with n = " + n);
        int start = firstNonZero;
        while(true) {
            if(start >= arr.length) {
                //System.out.println(" 1: " + Arrays.toString(arr));
                return -1;
            }
            if(arr[start]>=n) {
                arr[start] = arr[start] - n;
                //System.out.println("2 : " + Arrays.toString(arr));
                return arr[start+1];
            } else {
                n = n - arr[start];
                arr[start] = 0;
                if(start == firstNonZero) firstNonZero += 2;
                start += 2;
                //System.out.println("3 : " + Arrays.toString(arr));
            }
        }
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
