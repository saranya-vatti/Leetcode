class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length() == 0) return -1;
        int index=s.length();
        for(char i='a';i<='z';i++) {
            if(s.indexOf(i) != -1 && s.indexOf(i) == s.lastIndexOf(i)) {
                index = Math.min(index, s.indexOf(i));
            }
        }
        if(index == s.length()) return -1;
        return index;
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                pq.add(i);
            } else {
                pq.remove(map.get(s.charAt(i)));
            }
        }
        if(pq.isEmpty()) return -1;
        return pq.peek();
        */
    }
}
