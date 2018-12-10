class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<B.length;j++) {
                map.putIfAbsent(A[i]+B[j], 0);
                map.put(A[i]+B[j], map.get(A[i]+ B[j])+1);
            }
        }
        for(int i=0;i<C.length;i++) {
            for(int j=0;j<D.length;j++) {
                if(map.containsKey(-C[i]-D[j])) {
                    count += map.get(-C[i]-D[j]);
                }
            }
        }
        return count;
    }
}
