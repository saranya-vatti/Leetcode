class Solution {
    public char findTheDifference(String s, String t) {
        int[] sarr = new int[26];
        int[] tarr = new int[26];
        for(int i=0;i<s.length();i++) {
            sarr[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<t.length();i++) {
            int index = t.charAt(i) - 'a';
            tarr[index]++;
            if(tarr[index]>sarr[index]) return t.charAt(i);
        }
        return 'a';
    }
}
