class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi=0;
        for(int si=0; gi<g.length && si<s.length;si++) {
            if(g[gi] <= s[si]) gi++;
        }
        return gi;
    }
}
