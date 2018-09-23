class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++) {
            StringBuilder s = new StringBuilder();
            for(int j=0;j<words[i].length();j++) {
                int charIndex = words[i].charAt(j)-'a';
                String morseChar = code[charIndex];
                s.append(morseChar);
            }
            set.add(s.toString());
        }
        /*for(String elem: set) {
            System.out.println(set);
        }*/
        return set.size();
    }
}
