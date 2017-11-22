public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        HashMap<Integer, Integer> powerOf2 = new HashMap<>();
        powerOf2.put(0, 1);
        for(int i=1;i<=31;i++) {
            powerOf2.put(i, powerOf2.get(i-1)*2);
        }
        int result=0;
        String bin = Integer.toBinaryString(n);
        while(bin.length() != 32) {
            bin = "0" + bin;
        }
        System.out.println(bin);
        for(int i=0;i<bin.length();i++) {
            if(bin.charAt(i) == '1'){
                result += powerOf2.get(i);
            }
        }
        return result;
    }
}