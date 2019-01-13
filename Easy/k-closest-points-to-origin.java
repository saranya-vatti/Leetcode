class Solution {
    public int[][] kClosest(int[][] points, int K) {
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        List<Double> list = new ArrayList<Double>();
        for(int i=0;i<points.length;i++) {
            double dist = Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            map.put(dist, i);
            list.add(dist);
        }
        Collections.sort(list);
        int[][] ans = new int[K][2];
        for(int i=0;i<K;i++) {
            ans[i] = points[map.get(list.get(i))];
        }
        return ans;
    }
}
