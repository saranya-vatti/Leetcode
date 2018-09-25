class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<letters.length;i++) {
            set.add(letters[i]);
        }
        for(char i=(char)(target+1); i<= 'z';i++) {
            if(set.contains(i)) {
                return i;
            }
        }
        return letters[0];
    }
}
