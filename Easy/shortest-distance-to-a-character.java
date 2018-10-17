class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] arr = new int[S.length()];
        for(int i=0;i<S.length();i++) {
            String a = S.substring(0, i);
            int aIndex = a.lastIndexOf(C);
            int aDist, bDist;
            if(aIndex == -1) aDist = Integer.MAX_VALUE;
            else aDist = i-aIndex;
            String b = S.substring(i);
            int bIndex = i+b.indexOf(C);
            if(bIndex == i-1) bDist = Integer.MAX_VALUE;
            else bDist = bIndex-i;
            arr[i] = Math.min(aDist, bDist);
        }
        return arr;
    }
}
