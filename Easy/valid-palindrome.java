class Solution {
    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length()-1;
        while(start<end && start<str.length() && end>=0) {
            char s = Character.toLowerCase(str.charAt(start));
            char e = Character.toLowerCase(str.charAt(end));
            if(!(('a' <= s && s <= 'z') || ('0' <= s && s <= '9'))) {
                start++;
            } else if(!(('a' <= e && e <= 'z') || ('0' <= e && e <= '9'))) {
                end--;
            } else {
                if(s != e) return false;
                start++;
                end--;
            }
        }
        return true;
    }
}
