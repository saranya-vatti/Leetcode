class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] arr = new int[S.length()];
        int lastIndex = -1;
        for(int i=0;i<S.length();i++) {
            if(S.charAt(i) == C) {
                lastIndex = i;
                arr[i] = 0;
            } else {
                if(lastIndex == -1) arr[i] = Integer.MAX_VALUE;
                else arr[i] = i - lastIndex;
            }
        }
        for(int i=S.length()-1;i>=0;i--) {
            if(S.charAt(i) == C) {
                lastIndex = i;
            } else {
                arr[i] = Math.min(Math.abs(i - lastIndex), arr[i]);
            }
        }
        return arr;
    }
}
