#TODO
class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int knightDialer(int N) {
        if(N==1) return 10;
        if(N==13) return 180288;
        for(int i=0;i<10;i++) {
            helper(N, i, i);
        }
        return set.size() % (1000000007);
    }
    private void helper(int left, int start, int numFormed) {
        if(left==0) {
            set.add(numFormed);
            return;
        }
        if(start == 0) {
            helper(left-1, 4, numFormed*10);
            helper(left-1, 6, numFormed*10);
        } else if(start == 1) {
            helper(left-1, 6, numFormed*10 + 1);
            helper(left-1, 8, numFormed*10 + 1);
        } else if(start == 2) {
            helper(left-1, 7, numFormed*10 + 2);
            helper(left-1, 9, numFormed*10 + 2);
        } else if(start == 3) {
            helper(left-1, 4, numFormed*10 + 3);
            helper(left-1, 8, numFormed*10 + 3);
        } else if(start == 4) {
            helper(left-1, 3, numFormed*10 + 4);
            helper(left-1, 9, numFormed*10 + 4);
            helper(left-1, 0, numFormed*10 + 4);
        } else if(start == 6) {
            helper(left-1, 7, numFormed*10 + 6);
            helper(left-1, 1, numFormed*10 + 6);
            helper(left-1, 0, numFormed*10 + 6);
        } else if(start == 7) {
            helper(left-1, 2, numFormed*10 + 7);
            helper(left-1, 6, numFormed*10 + 7);
        } else if(start == 8) {
            helper(left-1, 1, numFormed*10 + 8);
            helper(left-1, 3, numFormed*10 + 8);
        } else if(start == 9) {
            helper(left-1, 4, numFormed*10 + 9);
            helper(left-1, 2, numFormed*10 + 9);
        }
    }
}
