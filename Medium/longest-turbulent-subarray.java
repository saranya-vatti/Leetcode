class Solution {
    public int maxTurbulenceSize(int[] A) {
        int maxlen = 1;
        for(int i=0;i<A.length-1;i++) {
            int j=i;
            int len = 1;
            if(j%2==0 && A[j]>A[j+1]) {
                while(j<A.length-1 && ((j%2==0 && A[j]>A[j+1]) || (j%2==1 && A[j]<A[j+1]))) {
                    len++;
                    j++;
                }
            } else if (j%2==1 && A[j]<A[j+1]) {
                while(j<A.length-1 && ((j%2==0 && A[j]>A[j+1]) || (j%2==1 && A[j]<A[j+1]))) {
                    len++;
                    j++;
                }
            } else if(j%2==0 && A[j]<A[j+1]){
                while(j<A.length-1 && ((j%2==0 && A[j]<A[j+1]) || (j%2==1 && A[j]>A[j+1]))) {
                    len++;
                    j++;
                }
            } else if(j%2==1 && A[j]>A[j+1]){
                while(j<A.length-1 && ((j%2==0 && A[j]<A[j+1]) || (j%2==1 && A[j]>A[j+1]))) {
                    len++;
                    j++;
                }
            }
            if(len>maxlen) maxlen = len;
        }
        return maxlen;
    }
}
