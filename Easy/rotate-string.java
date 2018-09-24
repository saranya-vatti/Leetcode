class Solution {
    public boolean rotateString(String A, String B) {
        if(B.length() != A.length()) return false;
        StringBuilder sb = new StringBuilder();
        sb.append(B).append(B);
        int index = sb.indexOf(A);
        if (index == -1) return false;
        return true;
    }
}
