class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char curr = s.charAt(i);
            if(!map.containsKey(curr)) {
                map.put(curr, new ArrayList<Integer>());
            }
            map.get(curr).add(i);
        }
        /*for(int i=0;i<26;i++) {
            char curr = (char) ('a' + i);
            ArrayList<Integer> alist = map.get(curr);
            if (alist != null) {
                System.out.print(curr + "->");
                System.out.println(Arrays.toString(alist.toArray()));
            }
        }*/
        for(int i=0;i<26;i++) {
            char curr = (char)('a' + i);
            ArrayList<Integer> alist = map.get(curr);
            if(alist != null) {
                for(int j=0;j<alist.size();j++) {
                    int start = alist.get(j);
                    for(int k=j; k<alist.size();k++) {
                        int end = alist.get(k);
                        int index = start + 1;
                        int limit = end - 1;
                        if((end - start) % 2 ==0) {
                            // odd len palin
                            limit = start + ((end - start) / 2) - 1;
                        } else {
                            limit = start + ((end - start + 1) / 2) - 1;
                        }
                        boolean isPalin = true;
                            if (s.charAt(index) != s.charAt(end - index + start)) {
                                isPalin = false;
                                break;
                            }
                            index++;
                        }
                        if(isPalin) {
//                            System.out.println(s.substring(start, end+1));
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}