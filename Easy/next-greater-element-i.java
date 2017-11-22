class Solution {
    private int findMax(int startingIndex, int[] arr, int num) {
        for(int i=startingIndex;i<arr.length;i++) {
            if(arr[i]>num) return arr[i];
        }
        return -1;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int[] res = new int[nums1.length];
        for(int i=0;i<nums2.length;i++) {
            map2.put(nums2[i], i);
        }
        for(int i=0;i<nums1.length;i++) {
            res[i] = findMax(map2.get(nums1[i]) + 1, nums2, nums1[i]);
        }
        return res;
    }
}