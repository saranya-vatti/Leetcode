class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> lastList = list;
        for(int i=0;i<rowIndex;i++) {
            list = new ArrayList<>();
            list.add(1);
            for(int j=0;j<lastList.size()-1;j++) {
                list.add(lastList.get(j) + lastList.get(j+1));
            }
            list.add(1);
            lastList = list;
        }
        return list;
    }
}
