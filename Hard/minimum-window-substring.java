class Solution {
    public String minWindow(String s, String t) {
        if(t == null || t.length() == 0 || t.length() > s.length()) return "";
        if(t.equals(s)) return s;
        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            tmap.putIfAbsent(t.charAt(i), 0);
            tmap.put(t.charAt(i), tmap.get(t.charAt(i)) + 1);
        }
        // System.out.println("1 tmap:");
        // print(tmap);
        String ans = "";
        int start = 0;
        for(int end=start;end<s.length();end++) {
            smap.putIfAbsent(s.charAt(end), 0);
            smap.put(s.charAt(end), smap.get(s.charAt(end)) + 1);
            // System.out.println("2 smap");
            // print(smap);
            if(isValid(smap, tmap)) {
                boolean flag = true;
                // System.out.println("3 ans = " + s.substring(start, end+1));
                if(ans.length() > end-start+1 || ans.length() == 0) {
                    ans = s.substring(start, end+1);
                }
                while(start<end && flag) {
                    smap.put(s.charAt(start), smap.get(s.charAt(start)) - 1);
                    start++;
                    flag = isValid(smap, tmap);
                    // System.out.println("4 start = " + start);
                    // System.out.println("5 end = " + end);
                    // print(smap);
                    if(!flag) {
                        // System.out.println("6 ans = " + s.substring(start-1, end+1));
                        if(ans.length() > end-start+2 || ans.length() == 0) {
                            ans = s.substring(start-1, end+1);                                
                            break;
                        }
                    } else {
                        // System.out.println("7 ans = " + s.substring(start, end+1));
                        if(ans.length() > end-start+1 || ans.length() == 0) {
                            ans = s.substring(start, end+1);
                        }
                    }
                 }
            }
        }        
        return ans;
    }
    private void print(HashMap<Character, Integer> map) {
        StringBuilder keys = new StringBuilder("");
        StringBuilder values = new StringBuilder("");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            keys.append(entry.getKey()).append("  ");
            values.append(entry.getValue()).append("  ");
        }
        System.out.println(keys);
        System.out.println(values);
    }
    private boolean isValid(HashMap<Character, Integer> smap, HashMap<Character, Integer> tmap) {
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if(!smap.containsKey(key) || value>smap.get(key)) {
                return false;
            }
        }
        return true;
    }
}
