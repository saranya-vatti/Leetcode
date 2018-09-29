class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder a = new StringBuilder(A);
        int i=1;
        for(;i<=(B.length()/A.length())+2;i++) {
            if(a.length() >= B.length() && a.indexOf(B) != -1) return i;
            a.append(A);
        }
        return -1;
    }
}
