class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        for(int i=0;i<s.length();i++) {
            extend(s, i, i);
            extend(s, i, i+1);
        }
        return count;
    }
    private void extend(String s, int left, int right) {
        while(left >=0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)) {
            System.out.println(s.substring(left, right+1));
            count++;
            left--;
            right++;
        }
    }
}