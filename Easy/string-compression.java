class Solution {
    public int compress(char[] chars) {
        int newArrPointer = 0;
        for(int i=0;i<chars.length;) {
            char newArrChar = chars[i++];
            chars[newArrPointer++] = newArrChar;
            int count=1;
            while(i<chars.length && chars[i]==newArrChar) {
                count++;
                i++;
            }
            if(count != 1) {
                Stack<Character> st = new Stack<>();
                while(count>0) {
                    st.push(Character.forDigit((count%10), 10));
                    count = count/10;
                }
                while(!st.isEmpty()) {
                    chars[newArrPointer++] = st.pop();
                }
            }
            //System.out.println(Arrays.toString(chars));
        }
        return newArrPointer;
    }
}
