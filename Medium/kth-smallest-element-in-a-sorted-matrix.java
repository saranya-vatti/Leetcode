class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length==0) return 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                pQueue.add(matrix[i][j]);
            }
        }
        while(!pQueue.isEmpty()) {
            int elem = pQueue.poll();
            if(k--==1) return elem;
        }
        return 0;
    }
}
