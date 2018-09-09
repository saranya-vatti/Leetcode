class Solution {
    public int[] fairCandySwap(int[] a, int[] b) {
        int suma=0;
        int sumb=0;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<a.length;i++) {
            suma+=a[i];
        }
        for(int i=0;i<b.length;i++) {
            sumb+=b[i];
        }
        int diff = suma-sumb;
        diff=diff/2;
        for(int i=0;i<a.length;i++) {
            int bIndex = binSearch(b, a[i]-diff,0,b.length-1);
            if(bIndex != -1) {
                int[] res = new int[2];
                res[0] = a[i];
                res[1] = b[bIndex];
                return res;
            }
        }
        return null;
    }
    private int binSearch(int[] a, int val, int start, int end) {
        if(end<start) return -1;
        if(a[start] == val) return start;
        if(a[end] == val) return end;
        int mid = (start+end)/2;
        if(a[mid]==val) return mid;
        if(val < a[mid]) return binSearch(a, val, start+1, mid-1);
        return binSearch(a, val, mid+1, end-1);
    }
}