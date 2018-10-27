class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> generate(int numRows) {
        ans = new ArrayList<>();
        if(numRows == 0) return ans;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(list);
        List<Integer> lastList = list;
        for(int i=1;i<numRows;i++) {
            list = new ArrayList<>();
            list.add(1);
            for(int j=0;j<lastList.size()-1;j++) {
                list.add(lastList.get(j) + lastList.get(j+1));
            }
            list.add(1);
            ans.add(list);
            lastList = list;
        }
        return ans;
    }
}
