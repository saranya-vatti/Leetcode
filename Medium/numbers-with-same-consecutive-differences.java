class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        Stack<Integer> st = new Stack<>();
        int start = 1;
        if(N==1) start = 0;
        for(;start<=9;start++) {
            st.push(start);
        }
        int numDigits = 1;
        while(numDigits <N) {
            Stack<Integer> newSt = new Stack<>();
            while(!st.isEmpty()) {
                int num = st.pop();
                for(int i=0;i<=9;i++) {
                    if(num%10 - i == K || i - num%10 == K) {
                        newSt.push((num*10) + i);
                    }
                }
            }
            st  = newSt;
            numDigits++;
        }
        int[] result = new int[st.size()];
        int i=0;
        while(!st.isEmpty()) {
            result[i++] = st.pop();
        }
        return result;
    }
}
