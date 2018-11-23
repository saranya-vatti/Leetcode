class Solution {
    public boolean validPalindrome(String s) {
        int i = isPalin(s);
        if(i == -1) return true;
        return isPalin(s.substring(i+1, s.length()-i)) == -1 || isPalin(s.substring(i, s.length()-i-1)) == -1;
    }
    private int isPalin(String s) {
        //System.out.println("Checking if " + s + " is palin");
        for(int i=0;i<s.length()/2;i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) {
                return i;
            }
        }
        return -1;
    }
}
