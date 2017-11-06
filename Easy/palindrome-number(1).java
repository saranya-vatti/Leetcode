class Solution {
    public boolean isPalindrome(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE || x < 0) {
            return false;
        }
        if (x/10 == 0) return true;
        int orig = x;
        int rev = 0;
        while (x > 0) {
            int digit = x%10;
            rev = rev*10 + digit;
            x = x/10;
        }
        if (rev == orig) return true;
        return false;
    }
}