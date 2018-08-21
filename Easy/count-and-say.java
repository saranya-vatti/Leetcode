class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String str = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();) {
            char curr = str.charAt(i);
            int count = 0;
            while(i<str.length() && str.charAt(i) == curr) {
                count++;
                i++;
            }
            sb.append(count).append(curr);
        }
        return sb.toString();
    }
}
