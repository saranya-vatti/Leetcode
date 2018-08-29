class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==0 || num==1) return true;
        if(num==2) return false;
        boolean isPrime = true;
        for(long i=2;i*i<=num;i++) {
            int count = 0;
            while(num%i == 0) {
                num/=i;
                count++;
                isPrime = false;
            }
            if(count%2!=0)
                return false;
        }
        return !isPrime && num==1;
    }
}
