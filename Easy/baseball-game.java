class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        for(int i=0;i<ops.length;i++) {
            if(ops[i].equals("C")) st.pop();
            else if(ops[i].equals("D")) st.push(st.peek()*2);
            else if(ops[i].equals("+")) {
                int top = st.pop();
                int curr = top+st.peek();
                st.push(top);
                st.push(curr);
            } else {
                st.push(Integer.parseInt(ops[i]));
            }
        }
        //System.out.println(Arrays.toString(st.toArray()));
        while(!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
}
