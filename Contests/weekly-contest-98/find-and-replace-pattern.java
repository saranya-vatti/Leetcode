class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> ans = new ArrayList<>();
        for(int j=0;j<words.length;j++) {
            char[] sArr = words[j].toCharArray();
            char[] tArr = pattern.toCharArray();
            HashMap<Character, Character> replaceMap = new HashMap<>();
            HashMap<Character, Character> reverseReplaceMap = new HashMap<>();
            boolean fail = false;
            for(int i=0;i<sArr.length;i++) {
                if(replaceMap.containsKey(sArr[i])) {
                    if(replaceMap.get(sArr[i]) != tArr[i]) {
                        fail = true;
                        break;
                    }
                } else {
                    replaceMap.put(sArr[i], tArr[i]);
                }
                if(reverseReplaceMap.containsKey(tArr[i])) {
                    if(reverseReplaceMap.get(tArr[i]) != sArr[i]) {
                        fail = true;
                        break;
                    }
                } else {
                    reverseReplaceMap.put(tArr[i], sArr[i]);
                }
            }
            if(!fail) {
                ans.add(words[j]);
            }
        }
        return ans;
    }
}