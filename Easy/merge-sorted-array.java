class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int k=0,i=0,j=0;
        while(i<m && j<n) {
            if(nums1[i]>nums2[j]) {
                res[k++]=nums2[j++];
            } else {
                res[k++]=nums1[i++];
            }
        }
        while(i<m) {
            res[k++]=nums1[i++];
        }
        while(j<n) {
            res[k++]=nums2[j++];
        }
        for(i=0;i<m+n;i++) {
            nums1[i] = res[i];
        }
    }
}
