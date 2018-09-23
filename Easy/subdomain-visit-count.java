class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<cpdomains.length;i++) {
            StringBuilder sb = new StringBuilder();
            String count = cpdomains[i].split(" ")[0];
            String domain = cpdomains[i].split(" ")[1];
            while(true) {
                if(!map.containsKey(domain)) {
                    map.put(domain, 0);
                }
                map.put(domain, Integer.parseInt(count) + map.get(domain));
                if(domain.indexOf(".") == -1) break;
                domain = domain.substring(domain.indexOf(".")+1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            sb.append(" ");
            sb.append(key);
            list.add(sb.toString());
        }
        return list;
    }
}
