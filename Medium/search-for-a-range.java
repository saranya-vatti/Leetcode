// [5,7,7,8,8,10]
// 8
// [3,4]
class Solution {
    private int getStart(int[] nums, int target, int start, int end) {
        if(nums.length == 0 || start < 0 || end > nums.length-1 || end <start) return -1;
        int s = nums[start];
        int e = nums[end];
        int mid = (start+end)/2;
        int m = nums[mid];
        int t = target;
        if(s<t && t<m) {
            return getStart(nums, t, start+1, mid-1);
        }
        if(m<t && t<e) {
            return getStart(nums, t, mid+1, end-1);
        }
        if(t<s || t>e) return -1;
        if(s==t) {
            return start;
        }
        if(m==t) {
            int tmp = getStart(nums, t, start+1, mid-1);
            if(tmp != -1) {
                return tmp;
            }
            return mid;
        }
        if(e==t) {
            int tmp = getStart(nums, t, mid+1, end-1);
            if(tmp != -1) {
                return tmp;
            }
            return end;
        }
        return -1;
    }
    private int getEnd(int[] nums, int target, int start, int end) {
        if(nums.length == 0 || start < 0 || end > nums.length-1 || end <start) return -1;
        int s = nums[start];
        int e = nums[end];
        int mid = (start+end)/2;
        int m = nums[mid];
        int t = target;
        if(s<t && t<m) {
            return getEnd(nums, t, start+1, mid-1);
        }
        if(m<t && t<e) {
            return getEnd(nums, t, mid+1, end-1);
        }
        if(t<s || t>e) return -1;
        if(e==t) {
            return end;
        }
        if(m==t) {
            int tmp = getEnd(nums, t, mid+1, end-1);
            if(tmp != -1) {
                return tmp;
            }
            return mid;
        }
        if(s==t) {
            int tmp = getEnd(nums, t, start+1, mid-1);
            if(tmp != -1) {
                return tmp;
            }
            return start;
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        res[0] = getStart(nums, target, 0, nums.length-1);
        res[1] = getEnd(nums, target, 0, nums.length-1);
        return res;
    }
}