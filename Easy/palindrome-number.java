class Solution {
    public boolean isPalindrome(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE || x < 0) {
            return false;
        }
        if (x/10 == 0) return true;
        String num = Integer.toString(x);
        for (int i = 0; i <= num.length()/2; i++) {
            if(num.charAt(i) != num.charAt(num.length() - i - 1)) return false;
        }
        return true;
    }
}