class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> fav = new HashMap<>();
        int leastIndexSum = Integer.MAX_VALUE;
        for(int i=0;i<list1.length;i++) {
            fav.put(list1[i], i);
        }
        for(int i=0;i<list2.length;i++) {
            if(fav.containsKey(list2[i])) {
                int indexSum = fav.get(list2[i]) + i;
                if(indexSum < leastIndexSum) {
                    list.clear();
                    list.add(list2[i]);
                    leastIndexSum = indexSum;
                } else if (indexSum == leastIndexSum) {
                    list.add(list2[i]);
                }
            }
        }
        String[] ans = new String[list.size()];
        for(int i=0;i<list.size();i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
