// "ACGTACGTAC" - []
// "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" - ["AAAAACCCCC", "CCCCCAAAAA"]
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        int len = s.length();
        if(len <= 10) return list;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<=len-10;i++) {
            String sub = s.substring(i, i+10);
            if(set.contains(sub) && !list.contains(sub)) {
                list.add(sub);
                // System.out.println(sub);
            } else {
                set.add(sub);
                // System.out.println(Arrays.toString(set.toArray()));
            }
        }
        return list;
    }
}