class Solution {
    public String[] reorderLogFiles(String[] logs) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<logs.length;i++) {
            map.put(logs[i], i);
        }
        Arrays.sort(logs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if(isLetterLog(s1) && !isLetterLog(s2)) {
                    return -1;
                }
                if(!isLetterLog(s1) && isLetterLog(s2)) {
                    return 1;
                }
                if(isLetterLog(s1)) {
                    if(getLog(s1).compareTo(getLog(s2)) == 0) {
                        return getIdentifier(s1).compareTo(getIdentifier(s2));
                    } else {
                        return getLog(s1).compareTo(getLog(s2));
                    }
                }
                return map.get(s1) < map.get(s2) ? -1 : 1;
            }
        });
        return logs;
    }
    private boolean isLetterLog(String s) {
        return s.split(" ")[1].matches("[a-z]*");
    }
    private String getLog(String s) {
        return s.substring(s.indexOf(" ")+1);
    }
    private String getIdentifier(String s) {
        return s.substring(0, s.indexOf(" "));
    }
}
