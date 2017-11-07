class Solution {
    public int hammingDistance(int x, int y) {
        char[] xArr = Integer.toBinaryString(x).toCharArray();
        char[] yArr = Integer.toBinaryString(y).toCharArray();
        System.out.println(Arrays.toString(xArr));
        System.out.println(Arrays.toString(yArr));
        int count=0;
        int i=xArr.length-1;
        int j=yArr.length-1;
        while(i>=0 && j>=0) {
            if(xArr[i]!=yArr[j]) {
                count++;
            }
            i--;
            j--;
        }
        while(i>=0) {
            if(xArr[i]=='1') count++;
            i--;
        }
        while(j>=0) {
            if(yArr[j]=='1') count++;
            j--;
        }
        return count;
    }
}   