class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length-2;
        while(lo<=hi) {
            //System.out.println("lo = " + lo + " and hi = " + hi);
            int mid=(lo+hi)/2;
            if(letters[mid] <= target && letters[mid+1] > target) return letters[mid+1];
            if(letters[mid] <= target) lo = mid+1;
            else hi = mid-1;
        }
        return letters[0];
    }
}
