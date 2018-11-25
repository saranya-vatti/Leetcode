class Solution {
    public int minIncrementForUnique(int[] A) {
        if(A == null || A.length == 0) return 0;
        Arrays.sort(A);
        boolean[] arr = new boolean[Math.max(A[A.length-1], A.length)+50000];
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0;i<A.length;i++) {
            if(arr[A[i]]) {
                qu.add(A[i]);
            } else {
                arr[A[i]] = true;
            }
        }
        int count = 0, i=0;
        while(!qu.isEmpty()) {
            int num = qu.remove();
            int num2 = num;
            while(num2<arr.length && arr[num2]) {
                num2++;
            }
            //System.out.println("num = " + num);
            //System.out.println("num2 = " + num2);
            count += num2-num;
            //System.out.println("count = " + count);
            arr[num2] = true;
        }
        return count;
    }
}
