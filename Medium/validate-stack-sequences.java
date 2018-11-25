class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || pushed.length == 0) return true;
        HashMap<Integer, Integer> rank = new HashMap<>();
        for(int i=0;i<pushed.length;i++) {
            rank.put(pushed[i], i);
        }
        int minPopped = 0;
        for(int i=0;i<popped.length;i++) {
            if(rank.get(popped[i]) >= minPopped) {
                minPopped = rank.get(popped[i]) - 1;
                while(minPopped>0 && pushed[minPopped] == -1) {
                    minPopped --;
                    
                }
                pushed[rank.get(popped[i])] = -1;
            } else {
                return false;
            }
        }
        return true;
    }
}
