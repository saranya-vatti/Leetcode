class Solution {
    public String toLowerCase(String str) {
        char[] arr = new char[str.length()];
        for(int i=0;i<str.length();i++) {
            int ch = (int)str.charAt(i);
            if(65 <= ch && ch <= 90) arr[i] = (char)(ch+32);
            else arr[i] = (char)ch;
        }
        return new String(arr);
    }
}
