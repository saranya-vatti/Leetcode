import java.math.*;
class Solution {
    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<candies.length;i++) {
            if(!map.containsKey(candies[i])) {
                map.put(candies[i], 0);
            }
            map.put(candies[i], map.get(candies[i]) + 1);
        }
        return Math.min(candies.length/2, map.size());
    }
}