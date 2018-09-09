class StockSpanner {
    ArrayList<Integer> list;
    ArrayList<Integer> helperList;

    public StockSpanner() {
        list = new ArrayList<>();
        helperList = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        if(list.size() == 1) {
            helperList.add(1);
            return 1;
        }
        for(int i=list.size()-2;i>=0;i-=helperList.get(i)) {
            if(list.get(i) > price) {
                helperList.add(list.size() - i - 1);
                return list.size() - i - 1;
            }
        }
        helperList.add(list.size());
        return list.size();
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
