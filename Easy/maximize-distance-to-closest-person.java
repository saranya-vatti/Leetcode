class Solution {
    public int maxDistToClosest(int[] seats) {
        int prevIndex, lastIndex;
        int max;
        int i = 0;
        while(seats[i]==0) {
            i++;
        }
        max = i;
        prevIndex = i;
        i=seats.length-1;
        while(seats[i]==0) {
            i--;
        }
        if(max < seats.length-i-1) max = seats.length-i-1;
        lastIndex = i;
        for(i=prevIndex;i<=lastIndex;i++) {
            if(seats[i] == 1) {
                int d = (i-prevIndex)/2;
                if(max<d) max = d;
                prevIndex = i;
            }
        }
        return max;
    }
}
