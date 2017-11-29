// "aaabaaaa" - "aaabaaa"
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        int cen = 0;
        String maxString = "";
        int len = s.length();
        while(cen < len) {
            int i=cen-1;
            int j=cen+1;
            while(i>=0 && j<len && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            if(maxString.length() < j-i-1) {
                maxString = s.substring(i+1, j);
                //System.out.println("Case 1 : " + maxString);
            }
            cen++;
        }
        int cenLeft = 0;
        int cenRight = 1;
        while(cenLeft>=0 && cenRight<len) {
            //System.out.println("Case 2 : " + s.substring(cenLeft, cenRight+1));
            while(cenLeft>=0 && cenRight<len && s.charAt(cenLeft) == s.charAt(cenRight)) {
                //System.out.println("Case 3 : " + s.substring(cenLeft, cenRight+1));
                cenLeft--;
                cenRight++;
            }
            if(maxString.length() < cenRight-cenLeft-1) {
                maxString = s.substring(cenLeft+1, cenRight);
                //System.out.println("Case 4 : " + maxString);
            }
            cenLeft = (cenLeft + cenRight + 1)/2;
            cenRight=cenLeft+1;
        }
        return maxString;
    }
}