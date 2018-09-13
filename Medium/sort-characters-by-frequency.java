class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Character arr[] = new Character[s.length()]; 
        for(int i=0;i<s.length();i++) {
            char curr = s.charAt(i);
            if(!map.containsKey(curr)) {
                map.put(curr, 0);
            }
            map.put(curr, map.get(curr) + 1);
            arr[i] = curr;
        }
        Arrays.sort(arr);
        Arrays.sort(arr, new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                if(map.get(c2) == map.get(c1)) return c1.compareTo(c2);
                return map.get(c2) - map.get(c1);
            }
        });
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            ans.append(arr[i]);
        }
        return ans.toString();
    }
}
