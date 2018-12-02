class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        if(deck==null || deck.length<=1) return deck;
        int[] ans = new int[deck.length];
        Arrays.sort(deck);
        if(deck.length==2) return deck;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(deck[deck.length-2]);
        list.add(deck[deck.length-1]);
        while(list.size()<deck.length) {
            list.add(0, deck[deck.length-list.size()-1]);
            list.add(1, list.get(list.size()-1));
            list.remove(list.size()-1);
            
        }
        for(int i=0;i<list.size();i++) {
            deck[i] = list.get(i);
        }
        return deck;
    }
}
