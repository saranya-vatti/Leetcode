class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        if(words == null || words.length == 0) return list;
        StringBuilder sentence = new StringBuilder();
        for(int i=0;i<words.length;) {
            if(sentence.length() == 0 && words[i].length() == maxWidth) {
                sentence.append(words[i]);
                i++;
                list.add(sentence.toString());
                sentence = new StringBuilder();
            } else if(sentence.length() + words[i].length() + 1 == maxWidth) {
                if(sentence.length() == 0) sentence.append(words[i]).append(" "); // ["Listen","to","many,","speak","to","a","few."] - for "many," add the " "
                else sentence.append(" ").append(words[i]);
                i++;
                list.add(sentence.toString());
                sentence = new StringBuilder();
            } else if(sentence.length() + words[i].length() + 1 > maxWidth) {
                sentence = justify(sentence, maxWidth, i==words.length);
                list.add(sentence.toString());
                sentence = new StringBuilder();
            } else {
                if(sentence.length() == 0) sentence.append(words[i]);
                else sentence.append(" ").append(words[i]);
                i++;
                if(i==words.length) {
                    sentence = justify(sentence, maxWidth, true);
                    list.add(sentence.toString());
                }
            }
        }
        return list;
    }
    private StringBuilder justify(StringBuilder str, int len, boolean isLast) {
        StringBuilder ans = new StringBuilder();
        String[] arr = str.toString().split(" ");
        int numSpaces = arr.length - 1;
        if(isLast || numSpaces == 0) {
            while(str.length() < len) {
                str.append(" ");
            }
            return str;
        } else {
            int totWordSize = str.length() - numSpaces;
            int rem = (len - totWordSize) % numSpaces;
            int div = (len - totWordSize) / numSpaces;
            for(int i=0;i<arr.length-1;i++) {
                ans.append(arr[i]);
                for(int j=1;j<=div;j++) {
                    ans.append(" ");
                }
                if(rem>0) {
                    ans.append(" ");
                    rem--;
                }
            }
            ans.append(arr[arr.length - 1]);
            return ans;
        }
    }
}
