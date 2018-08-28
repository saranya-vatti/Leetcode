class Solution {
    public String reverseStr(String s, int k) {
        int next = 0;
        int start, end;
        int len = s.length();
        StringBuilder str = new StringBuilder();
        while(next<len) {
            if(len-next < k) {
                start = len-1;
                end = next;
                next = len;
            } else if(len-next >= k && len-next < 2*k) {
                start = next+k-1;
                end = next;
                next = len;
            } else {
                start = next+k-1;
                end = next;
                next = next + 2*k;
            }
            for(int i=start;i>=end;i--) {
                str.append(s.charAt(i));
            }
            for(int i=start+1;i<next;i++) {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
    
}
