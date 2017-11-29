class Solution {
    public String reverseString(String s) {
        if(s.equals("")) return s;
        StringBuilder str = new StringBuilder("");
        for(int i=s.length()-1;i>=0;i--) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}