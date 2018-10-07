class Solution {
    public String reverseOnlyLetters(String S) {
        int replaceWithIndex = S.length()-1;
        int index = 0;
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        while(index < replaceWithIndex) {
            if(isLetter(S.charAt(index)) && isLetter(S.charAt(replaceWithIndex))) {
                str1.append(S.charAt(replaceWithIndex--));
                str2.insert(0, S.charAt(index++));
            } else {
                if(!isLetter(S.charAt(replaceWithIndex))) {
                    str2.insert(0, S.charAt(replaceWithIndex--));
                }
                if(index < replaceWithIndex && !isLetter(S.charAt(index))) {
                    str1.append(S.charAt(index++));
                } 
            }
            // System.out.println(str1);
            // System.out.println(str2);
            // System.out.println();
        }
        if(index == replaceWithIndex) str1.append(S.charAt(index));
        str1.append(str2);
        return str1.toString();
    }
    private boolean isLetter(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }
}
