class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=numbers.length-1;i>0;i--) {
            if(target>=numbers[i]) {
                int index = binSearch(numbers, target-numbers[i], 0, i-1);
                if(index != -1) {
                    int[] arr = new int[2];
                    arr[0] = index+1;
                    arr[1] = i+1;
                    return arr;
                }
            }
        }
        int[] arr = {1, 2};
        return arr;
    }
    private int binSearch(int[] arr, int target, int start, int end) {
        if(end<start) return -1;
        if(arr[start] == target) return start;
        if(arr[end] == target) return end;
        int mid = (start+end)/2;
        if(arr[mid] == target) return mid;
        if(arr[mid]<target) return binSearch(arr, target, mid+1, end-1);
        return binSearch(arr, target, start+1, mid-1);
        
    }
}
