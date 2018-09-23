class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int[] ans = new int[2];
        if(S.length()==0) {ans[0]=0; ans[1]=0; return ans; }
        int lines=1;
        int currentWidth=0;
        for(int i=0;i<S.length();i++) {
            int width = widths[S.charAt(i)-'a'];
            if(currentWidth+width > 100) {
                lines++;
                currentWidth=width;
            } else {
                currentWidth+=width;
            }
        }
        ans[0]=lines;
        ans[1]=currentWidth;
        return ans;
    }
}
