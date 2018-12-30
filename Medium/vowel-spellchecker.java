class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> exact = new HashSet<>();
        HashMap<String, String> caseinsensitive = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();
        for(int i=0;i<wordlist.length;i++) {
            exact.add(wordlist[i]);
            if(!caseinsensitive.containsKey(wordlist[i].toLowerCase())) {
                caseinsensitive.put(wordlist[i].toLowerCase(), wordlist[i]);
            }
            String vow = rep(wordlist[i]);
            if(!vowel.containsKey(vow)) {
                vowel.put(vow, wordlist[i]);
            }
        }
        String[] answer = new String[queries.length];
        for(int i=0;i<queries.length;i++) {
            if(exact.contains(queries[i])) {
                answer[i] = queries[i];
            } else if(caseinsensitive.containsKey(queries[i].toLowerCase())) {
                answer[i] = caseinsensitive.get(queries[i].toLowerCase());
            } else if(vowel.containsKey(rep(queries[i]))) {
                answer[i] = vowel.get(rep(queries[i]));
            } else {
                answer[i] = "";
            }
        }
        return answer;
    }
    private String rep(String str) {
        str = str.toLowerCase();
        str = str.replace('a', '?');
        str = str.replace('e', '?');
        str = str.replace('i', '?');
        str = str.replace('o', '?');
        return str.replace('u', '?');
    }
}
