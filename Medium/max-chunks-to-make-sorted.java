class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunk=0;
        for(int i=0;i<arr.length;) {
            int end = arr[i];
            for(int j=i;j<=end;j++) {
                end = Math.max(end, arr[j]);
            }
            //System.out.println(end);
            chunk++;
            i=end+1;
        }
        return chunk;
    }
}
