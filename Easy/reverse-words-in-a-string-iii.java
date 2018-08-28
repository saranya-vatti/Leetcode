class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder str = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            String word = arr[i];
            for(int j=word.length()-1;j>=0;j--) {
                str.append(word.charAt(j));
            }
            if(i!= arr.length-1) str.append(" ");
        }
        return str.toString();
    }
}
