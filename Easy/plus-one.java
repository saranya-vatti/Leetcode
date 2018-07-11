class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> alist = new ArrayList<>();
        int carry = 1;
        int digitCounter = digits.length - 1;
        while(digitCounter >=0 || carry >0) {
            int sum = 0;
            if(digitCounter >= 0) {
                sum = digits[digitCounter--] + carry;
            } else {
                sum = carry;
            }
            int dig = sum%10;
            carry = sum/10;
            alist.add(0,dig);
        }
        int[] result = new int[alist.size()];
        for(int i=0;i<alist.size();i++) {
            result[i] = alist.get(i);
        }
        return result;
    }
}
