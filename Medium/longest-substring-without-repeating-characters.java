// "ohomm" - 3
// "pwwkew" - 3
class Solution {
    private HashSet<Character> count;
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        count = new HashSet<Character>();
        int maxLen = 1;
        int len = s.length();
        for(int i=0;i<len && (len-i)>maxLen;) {
            for(int j=i;j<len;) {
                if(!count.contains(s.charAt(j))) {
                    count.add(s.charAt(j));
                    //System.out.println(Arrays.toString(count.toArray()));
                    if(maxLen<count.size()) maxLen = count.size();
                    if(maxLen == len) return maxLen;
                    j++;
                } else {
                    count.remove(s.charAt(i));
                    i++;
                    //System.out.println(Arrays.toString(count.toArray()));
                }
            }
        }
        return maxLen;
    }
}