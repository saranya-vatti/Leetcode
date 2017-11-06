import java.math.BigInteger;
class Solution {
    public int reverse(int x) {
        BigInteger min = new BigInteger(Integer.toString(Integer.MIN_VALUE));
        BigInteger max = new BigInteger(Integer.toString(Integer.MAX_VALUE));
        String num = Integer.toString(x);
        String reverse = "";
        for (int i = num.length() - 1; i > 0; i--) {
            reverse += num.charAt(i);
        }
        if (num.charAt(0) == '-') {
            reverse = "-" + reverse;
        } else {
            reverse += num.charAt(0);
        }
        BigInteger reversedBI = new BigInteger(reverse);
        if (min.compareTo(reversedBI) > 0 || max.compareTo(reversedBI) < 0) {
            return 0;
        }
        return Integer.parseInt(reverse);
    }
}