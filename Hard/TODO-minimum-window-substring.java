//Outputs first window found as opposed to minimum window
class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int sContains = 0;
        HashMap<Character, Integer> tfreq = new HashMap<>();
        HashMap<Character, ArrayList<Integer>> inserted= new HashMap<>();
        ArrayList<Integer> insertedIndexes = new ArrayList<>();
        int minIndex = -1;
        int maxIndex = -1;
        for(int i=0;i<t.length();i++) {
            char curr = t.charAt(i);
            if(!tfreq.containsKey(curr)) {
                tfreq.put(curr, 0);
            }
            tfreq.put(curr, tfreq.get(curr)+1);
        }
        for(int i=0;i<s.length();i++) {
            char curr = s.charAt(i);
            if(tfreq.containsKey(curr)) {
                if(minIndex == -1) minIndex = i;
                if(!inserted.containsKey(curr) || inserted.get(curr).size() < tfreq.get(curr)) {
                    if(!inserted.containsKey(curr)) {
                        inserted.put(curr, new ArrayList<Integer>());
                    }
                    inserted.get(curr).add(i);
                    insertedIndexes.add(i);
                    sContains++;
                    if(sContains == t.length()) {
                        maxIndex = i;
                        break;
                    }
                } else if (inserted.get(curr).size() == tfreq.get(curr)) {
                    insertedIndexes.removeAll(Arrays.asList(inserted.get(curr).get(0)));
                    inserted.get(curr).remove(0); // values: list.removeAll(Arrays.asList(2)); // index - list.remove(2);
                    inserted.get(curr).add(i);
                    insertedIndexes.add(i);
                    minIndex = insertedIndexes.get(0);
                }
            }
            System.out.println("sContains = " + sContains);
            System.out.printf("minIndex = %s, maxIndex = %s\n", minIndex, maxIndex);
        }
        return minIndex == -1 || maxIndex == -1 || sContains < t.length() ? "" : s.substring(minIndex,maxIndex+1);
    }
}