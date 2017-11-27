// [1,0,0,0,1,0,0], 2 - true
// 
import java.lang.*;
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        if(flowerbed.length == 1) {
            if(flowerbed[0] == 1) return false;
            if (n==1) return true;
        }
        int max = 0;
        int curr = 0;
        while(curr<flowerbed.length) {
            int count=0;
            if(curr == 0 && flowerbed[curr] == 0) count++;
            while(curr<flowerbed.length && flowerbed[curr] != 1) {
                count++;
                curr++;
            }
            count = count-1;
            if(curr != flowerbed.length) {
                count--;
            }
            curr++;
            if(count<=0) continue;
            max = max + (count/2);
            if(count%2 == 1) max++;
        }
        System.out.println("max = "+ max);
        return n>=0 && n<=max;
    }
}