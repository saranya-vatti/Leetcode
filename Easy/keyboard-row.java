class Solution {
    public String[] findWords(String[] words) {
        int[] layout = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
        List<String> result = new ArrayList<String>();
        for(int i=0;i<words.length;i++) {
            boolean isValid = true;
            char[] arr = words[i].toLowerCase().toCharArray();
            int row = layout[arr[0]-'a'];
            for(int j=0;j<arr.length;j++) {
                if(row != layout[arr[j]-'a']) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) result.add(words[i]);
        }
        return result.toArray(new String[result.size()]);
    }
}