// "  " : 0
// "+" : 0
// "-" : 0
// "1234" : 1234
// "   adsdfsdf 1234" : 0
// " asdaadsd 2147483647" : 0
// "    2147483647" : 2147483647
// "    2147483649" : 2147483647
// "  -2147483649": -2147483647
// "+-2" : 0
// "-2147483647": -2147483647
class Solution {
    public int myAtoi(String s) {
        if(s.equals("")) return 0;
        boolean negate = false;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int i=0;
        while(i<s.length() && s.charAt(i)== ' ') {
            i++;
        }
        if(i<s.length() && s.charAt(i) == '+') {
            i++;
        } else if(i<s.length() && s.charAt(i) == '-') {
            negate = true;
            i++;
        }
        int num = 0;
        while(i<s.length() && '0'<=s.charAt(i) && s.charAt(i) <= '9') {
            int dig = s.charAt(i) - '0';
            if(num>max/10 || (num==max/10 && dig>max%10)) {
                if (negate) return min;
                return max;
            }
            num = (num*10) + dig;
            i++;
        }
        return negate ? -num : num;
    }
}