class Solution {
    public int minDeletionSize(String[] A) {
        if(A.length == 1) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<A[0].length();i++) {
            int index = 0;
            char curr = A[index].charAt(i);
            for(index=1;index<A.length;index++) {
                if(!set.contains(i) && A[index].charAt(i)<curr) set.add(i);
                curr = A[index].charAt(i);
            }
        }
        return set.size();
    }
}
