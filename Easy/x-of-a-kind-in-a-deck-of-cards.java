class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
         for(int i=0;i<deck.length;i++) {
             if(!map.containsKey(deck[i])) {
                 map.put(deck[i], 0);
             }
             map.put(deck[i], map.get(deck[i]) +1);
         }
        // for(int key: map.keySet()) {
        //     System.out.println(key + " -> " + map.get(key));
        // }
        int count = map.get(deck[0]);
        if(count < 2) return false;
        for(int key: map.keySet()) {
            int div = commDiv(map.get(key),count);
            //System.out.println("common div of " + map.get(key) + " and " + count + " = " + div);
            if(div == 0) return false;
        }
        return true;
    }
    private int gcd(int a, int b) 
    { 
        if (a == 0)  
            return b; 
          
        return gcd(b%a,a); 
    }
    
    // method to calculate all common divisors 
    // of two given numbers 
    // a, b --> input integer numbers 
    private int commDiv(int a,int b) 
    { 
        // find gcd of a,b 
        int n = gcd(a, b); 
        if(n==1) return 0;
       
        // Count divisors of n. 
        int result = 0; 
        for (int i=1; i<=Math.sqrt(n); i++) 
        { 
            // if 'i' is factor of n 
            if (n%i==0) 
            { 
                // check if divisors are equal 
                if (n/i == i) 
                    result += 1; 
                else
                    result += 2; 
            } 
        } 
        return result; 
    } 
}
