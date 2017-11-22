class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> squares = new HashMap<>();
        HashSet<Integer> squareset = new HashSet<>();
        for(int i=0;i<10;i++) {
            squares.put(i, i*i);
            squareset.add(i*i);
        }
        HashSet<Integer> visited = new HashSet<>();
        while(n != 1) {
            int tmp = n;
            int sum = 0;
            while(tmp!=0) {
                int digit = tmp%10;
                sum = sum + (squares.get(digit));
                tmp = tmp/10;
            }
            if(sum == 1) return true;
            if(visited.contains(sum) || sum == 0) return false;
            visited.add(sum);
            n = sum;
        }
        return true;
    }
}