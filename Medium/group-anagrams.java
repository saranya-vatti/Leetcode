class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] p = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++) {
            int prod = 1;
            for(int j=0;j<strs[i].length();j++) {
                int index = strs[i].charAt(j) - 'a';
                prod *= p[index];
            }
            //System.out.println("prod for " + strs[i] + " = " + prod);
            if(map.containsKey(prod)) {
                map.get(prod).add(strs[i]);
            } else {
                map.put(prod, new ArrayList<String>());
                map.get(prod).add(strs[i]);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
