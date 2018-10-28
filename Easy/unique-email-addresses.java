class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<emails.length;i++) {
            StringBuilder str = new StringBuilder();
            String localName = emails[i].split("@")[0];
            String domainName = emails[i].split("@")[1];
            for(int j=0;j<localName.length();j++) {
                char c = localName.charAt(j);
                if (c == '+') {
                    break;
                } else if(c != '.') {
                    str.append(c);
                }
            }
            str.append('@').append(domainName);
            set.add(str.toString());
        }
        return set.size();
    }
}
