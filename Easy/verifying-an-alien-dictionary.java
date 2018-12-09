class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        String[] temp = new String[words.length];
        for(int i=0;i<words.length;i++) {
            temp[i]= words[i];
        }
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String i1, String i2) {
                int i;
                for(i=0;i<i1.length() && i<i2.length(); i++) {
                    if(order.indexOf(i1.charAt(i)) < order.indexOf(i2.charAt(i))) {
                        return -1;
                    } else if(order.indexOf(i1.charAt(i)) > order.indexOf(i2.charAt(i))) {
                        return 1;
                    }
                }
                if(i==i1.length() && i==i2.length()) {
                    return 0;
                }
                if(i==i1.length()) {
                    return -1;
                }
                return 1;
            }
        });
        for(int i=0;i<words.length;i++) {
            if(temp[i]!=words[i]) return false;
        }
        return true;
    }
}
