class Solution {
    LinkedList<String> list;
    public List<String> restoreIpAddresses(String s) {
        list = new LinkedList<>();
        if(s.length() < 4 || s.length() > 12) return list;
        rec(new StringBuilder(), 0, s);
        return list;
    }
    
    private void rec(StringBuilder str, int index, String s) {
        if(index == 4) {
            if(str.length() == s.length() + 4) {
                list.add(str.substring(0, str.length()-1).toString());
                return;
            }
        }
        StringBuilder bkp = new StringBuilder(str);
        int start = str.length() - (index);
        if(s.length() >= start+1 && Integer.parseInt(s.substring(start, start+1)) <= 255) {
            rec(bkp.append(s.substring(start, start+1)).append("."), index+1, s);
            bkp = new StringBuilder(str);
        }
        if(s.length() >= start+2 && Integer.parseInt(s.substring(start, start+2)) <= 255 && s.charAt(start) != '0') {
            rec(bkp.append(s.substring(start, start+2)).append("."), index+1, s);
            bkp = new StringBuilder(str);
        }
        if(s.length() >= start+3 && Integer.parseInt(s.substring(start, start+3)) <= 255 && s.charAt(start) != '0') {
            rec(bkp.append(s.substring(start, start+3)).append("."), index+1, s);
        }
        
    }
}
