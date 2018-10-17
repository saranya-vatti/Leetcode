class Solution {
    public int[] shortestToChar(String S, char C) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<S.length();i++) {
            if(S.charAt(i) == C) {
                list.add(i);
            }
        }
        int[] arr = new int[S.length()];
        for(int i=0;i<arr.length;i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        for(int index = 0;index<S.length();index++) {
            for(int i=0;i<list.size();i++) {
                if(Math.abs(list.get(i)-index) < arr[index]) {
                    arr[index] = Math.abs(list.get(i)-index);
                }
            }
        }
        return arr;
    }
}
