class Solution {
    HashMap<Long, Double> pow = new HashMap<>();
    public double myPow(double x, long n) {
        if(pow.containsKey(n)) return pow.get(n);
        if(Double.compare(x,0.0) == 0) return 0.0;
        if(n==0) {
            pow.put(n, 1.0);
        }
        if(n==1) {
            pow.put(n, x);
        }
        if(n==2) {
            pow.put(n, x*x);
        }
        if(n==-1) {
            pow.put(n, 1/x);
        }
        if(n==-2) {
            pow.put(n, (1/x)*(1/x));
        }
        if(n%2==0) {
            pow.put(n, myPow(x, n/2) * myPow(x, n/2));
        } else if(n>0) {
            pow.put(n, myPow(x, n/2) * myPow(x, ((n+2)/2)));
        } else {
            pow.put(n, myPow(x, n/2) * myPow(x, ((n-2)/2)));
        }
        return pow.get(n);
    }
}