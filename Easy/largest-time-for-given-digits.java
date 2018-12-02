class Solution {
    HashSet<String> set;
    public String largestTimeFromDigits(int[] A) {
        set = new HashSet<>();
        heapPermutation(A, A.length, A.length);
        if(set.size() == 0) return "";
        
        //System.out.println(Arrays.toString(set.toArray()));
        return Collections.max(set);
    }
    //Generating permutation using Heap Algorithm 
    void heapPermutation(int a[], int size, int n) 
    { 
        // if size becomes 1 then prints the obtained 
        // permutation 
        if (size == 1) {
            StringBuilder str = new StringBuilder();
            if(a[0]<=2) {
                str.append((char)(a[0]+'0'));
                if(a[0] == 2 && a[1]<4) {
                    str.append((char)(a[1]+'0'));
                    str.append(":");
                    if(a[2]<=5) {
                        str.append((char)(a[2]+'0'));
                        str.append((char)(a[3]+'0'));
                        set.add(str.toString());
                    }
                } else if(a[0]<=1) {
                    str.append((char)(a[1]+'0'));
                    str.append(":");
                    if(a[2]<=5) {
                        str.append((char)(a[2]+'0'));
                        str.append((char)(a[3]+'0'));
                        set.add(str.toString());
                    }
                }
            }
        }
             
  
        for (int i=0; i<size; i++) 
        { 
            heapPermutation(a, size-1, n); 
  
            // if size is odd, swap first and last 
            // element 
            if (size % 2 == 1) 
            { 
                int temp = a[0]; 
                a[0] = a[size-1]; 
                a[size-1] = temp; 
            } 
  
            // If size is even, swap ith and last 
            // element 
            else
            { 
                int temp = a[i]; 
                a[i] = a[size-1]; 
                a[size-1] = temp; 
            } 
        } 
    } 
}
