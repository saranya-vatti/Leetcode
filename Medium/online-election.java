class TopVotedCandidate {
    int[] T;
    HashMap<Integer, Integer> personToVotesMap;
    int[] ans;
    int len;

    public TopVotedCandidate(int[] persons, int[] times) {
        T = times;
        len = persons.length;
        personToVotesMap = new HashMap<>();
        ans = new int[len];
        for(int i=0;i<len;i++) {
            if(!personToVotesMap.containsKey(persons[i])) {
                personToVotesMap.put(persons[i], 0);
            }
            personToVotesMap.put(persons[i], personToVotesMap.get(persons[i]) + 1);
            if(i==0) ans[i] = persons[i];
            else {
                if(personToVotesMap.get(ans[i-1]) > personToVotesMap.get(persons[i])) {
                    ans[i] = ans[i-1];
                } else {
                    ans[i] = persons[i];
                }
            }
        }
    }
    
    public int q(int t) {
        int ansIndex = binSearch(T, 0, len-1, t);
        return ans[ansIndex];
    }
    private int binSearch(int[] arr, int start, int end, int val) {
        if(start == end) {
            return start;
        }
        int mid = (start+end)/2;
        if(mid<arr.length-1) {
            if(arr[mid]<=val && arr[mid+1]>val) return mid;
            if(arr[mid]>val) return binSearch(arr, start, mid, val);
            return binSearch(arr, mid+1, end, val);
        }
        if(arr[mid] > val) return mid-1;
        return mid;
    }
    private int binSearch_bkp(int[] arr, int start, int end, int val) {
        for(int i=0; i<arr.length-1;i++) {
            if(arr[i] <=val && val < arr[i+1]) return i;
        }
        return arr.length-1;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
