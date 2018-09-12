class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Integer, HashSet<Character>> map1 = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char curr = s.charAt(i);
            if(!map.containsKey(curr)) {
                map.put(curr, 0);
            }
            int prevFreq = map.get(curr);
            if(map1.containsKey(prevFreq)) {
                if(map1.get(prevFreq).contains(curr))
                    map1.get(prevFreq).remove(curr);
            }
            int newFreq = prevFreq + 1;
            map.put(curr, newFreq);
            HashSet<Character> set;
            if(!map1.containsKey(newFreq)) {
                set = new HashSet<Character>();
            } else {
                set = map1.get(newFreq);
            }
            set.add(curr);
            map1.put(newFreq, set);
        }
        StringBuilder ans = new StringBuilder();
        for(int i=s.length();i>0;i--) {
            if(map1.containsKey(i)) {
                HashSet<Character> set = map1.get(i);
                for (char ch : set) {
                    for(int j=0;j<i;j++) {
                        ans.append(ch);
                    }
                }
            }
        }
        return ans.toString();
    }
}
