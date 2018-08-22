class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder str = new StringBuilder();
        for(int i=0;i<words.length;i++) {
            char start = words[i].toLowerCase().charAt(0);
            switch(start) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    str.append(words[i]);
                    break;
                default:
                    str.append(words[i].substring(1)).append(words[i].charAt(0));
                    break;
            }
            str.append("ma");
            adda(str, i);
            str.append(" ");
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
    private void adda(StringBuilder str, int index) {
        int tmp = index+1;
        while(tmp-->0) {
            str.append("a");
        }
    }
}
