// 0 - true
// 1 - true
// 2 - true
// 3 - false
// 4 - true
// 5 - true
// 2450 - true
// 3430 - false
// 999999999 - false
// https://en.wikipedia.org/wiki/Sum_of_two_squares_theorem
// https://en.wikipedia.org/wiki/Fermat%27s_theorem_on_sums_of_two_squares
class Solution {
    private void primeFactors(int n, HashMap<Integer, Integer> map) {
        if(n==0 || n==1 || n==2) {
            map.put(n, 1);
            return;
        }
        while (n%2 == 0) {
            if(!map.containsKey(2)) {
                map.put(2, 0);
            }
            map.put(2, map.get(2) + 1);
            n = n/2;
        }
        for (int i = 3; i <= (int)Math.sqrt(n); i = i+2) {
            while (n%i == 0) {
                if(!map.containsKey(i)) {
                    map.put(i, 0);
                }
                map.put(i, map.get(i) + 1);
                n = n/i;
            }
        }
        if (n > 2) {
            map.put(n, 1);
        }
    }
    public boolean judgeSquareSum(int c) {
        HashMap<Integer, Integer> map = new HashMap<>();
        primeFactors(c, map);
        if(map.containsKey(c) && c%2==1) return c%4 == 1;
        for (int key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
            if(key%4 == 3 && (map.get(key))%2 == 1) return false;
        }
        return true;
    }
}