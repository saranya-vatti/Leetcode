class Solution {
    public String longestWord(String[] words) {
        HashSet<String> set = new HashSet<>();
        String ans = "";
        for(int i=0;i<words.length;i++) {
            set.add(words[i]);
        }
        for(int i=0;i<words.length;i++) {
            boolean isAns = true;
            String w = words[i];
            int len = w.length();
            for(int j=1;j<len;j++) {
                if(!set.contains(w.substring(0,j))) isAns = false;
            }
            if(isAns) {
                if(ans.length() < len || (ans.length() == len && ans.compareTo(w) > 0)) {
                    ans = w;
                    //System.out.println(ans);
                }
            }
        }
        return ans;
    }
}
