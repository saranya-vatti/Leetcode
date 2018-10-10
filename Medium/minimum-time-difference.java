class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] arr = new boolean[1440];
        int firstIndex = Integer.MAX_VALUE, lastIndex = -1;
        for(int i=0;i<timePoints.size();i++) {
            int index = timePoints.get(i).indexOf(":");
            int index1 = Integer.parseInt(timePoints.get(i).substring(0, index))*60 + Integer.parseInt(timePoints.get(i).substring(index+1)) % 1440;
            if(arr[index1]) return 0;
            arr[index1] = true;
            firstIndex = Math.min(index1, firstIndex);
            lastIndex = Math.max(lastIndex, index1);
        }
        int minDiff = 1440 - lastIndex + firstIndex;
        for(int i=firstIndex+1;i<=lastIndex;i++) {
            if(arr[i]) {
                minDiff = Math.min(minDiff, i-firstIndex);
                firstIndex = i;
            }
        }
        return minDiff;
    }
}
