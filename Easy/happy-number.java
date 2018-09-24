class Solution {
    public boolean isHappy(int n) {
        int[] squares = {0,1,4,9,16,25,36,49,64,81};
        HashSet<Integer> visited = new HashSet<>();
        while(n != 1) {
            int tmp = n;
            int sum = 0;
            while(tmp!=0) {
                int digit = tmp%10;
                sum = sum + squares[digit];
                tmp = tmp/10;
            }
            if(visited.contains(sum)) return false;
            visited.add(sum);
            n = sum;
        }
        return true;
    }
}
