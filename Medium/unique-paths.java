class Solution {
    public int uniquePaths(int m, int n) {
        if(n==1 && m==1) return 1;
        int[][] numOfWays = new int[n][m];
        numOfWays[0][0] = 1;
        Queue<Integer> queuem = new LinkedList<>();
        Queue<Integer> queuen = new LinkedList<>();
        if(m>1) {
            queuen.add(0);
            queuem.add(1);
        }
        if(n>1) {
            queuen.add(1);
            queuem.add(0);
        }
        while(!queuem.isEmpty()) {
            int row = queuen.remove();
            int col = queuem.remove();
            if(numOfWays[row][col] != 0) continue;
            if(row>0) numOfWays[row][col] = (numOfWays[row][col] + numOfWays[row-1][col]);
            if(col>0) numOfWays[row][col] = (numOfWays[row][col] + numOfWays[row][col-1]);
            if(row==n-1 && col == m-1) return (int)(numOfWays[row][col]);
            if(col < m-1 && numOfWays[row][col+1] == 0) {
                queuen.add(row);
                queuem.add(col+1);
            }
            if(row < n-1 && numOfWays[row+1][col] == 0) {
                queuen.add(row+1);
                queuem.add(col);
            }
        }
        return numOfWays[n-1][m-1];
    }
}