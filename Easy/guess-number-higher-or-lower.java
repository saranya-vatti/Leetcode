/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return guessBin(1, n);
    }
    private int guessBin(int lo, int hi) {
        int mid = lo + (hi-lo)/2;
        if(guess(mid) == 0) return mid;
        else if(guess(mid)<0) return guessBin(lo,mid-1);
        return guessBin(mid+1, hi);
    }
}
