class Solution {
    public String addStrings(String num1, String num2) {
        int num1index = num1.length() - 1;
        int num2index = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder("");
        while(num1index>=0 || num2index>=0 || carry>0) {
            int sum = 0;
            if(num1index >= 0) {
                sum += Character.getNumericValue(num1.charAt(num1index)); // convert to int
                num1index--;
            }
            if(num2index >= 0) {
                sum += Character.getNumericValue(num2.charAt(num2index)); // convert to int
                num2index--;
            }
            sum += carry;
            carry = sum/10;
            result.insert(0, sum%10);
        }
        return result.toString();
    }
}