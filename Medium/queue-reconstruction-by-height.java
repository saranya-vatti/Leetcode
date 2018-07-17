import java.util.*;
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return people;
        int TOTAL = people.length;
        ArrayList<People> inputList = new ArrayList<>();
        for(int i=0;i<TOTAL;i++) {
            inputList.add(new People(people[i][0], people[i][1]));
        }
        Collections.sort(inputList, new QueueComparator());
        // System.out.println("sorted people = " + Arrays.toString(inputList.toArray()));
        ArrayList<People> list = new ArrayList<>();
        list.add(new People(inputList.get(0).height, inputList.get(0).k));
        for(int i=1;i<TOTAL;i++) {
            People person = inputList.get(i);
            int height = person.height;
            int inFront = person.k;
            int currIndex = 0; // index in list
            // System.out.println("list = " + Arrays.toString(list.toArray()));
            while(true) {
                if(currIndex == list.size()) {
                    list.add(new People(person.height, person.k));
                    break;
                }
                int currHeight = list.get(currIndex).height;
                if(inFront>0 && currHeight>=height) {
                    inFront--;
                    currIndex++;
                } else if(inFront>=0 && currHeight<height) {
                    currIndex++;
                } else if(inFront == 0){
                    list.add(currIndex, new People(person.height, person.k));
                    break;
                }
            }
        }
        int[][] ans = new int[people.length][2];
        for(int i=0;i<people.length;i++) {
            ans[i][0] = list.get(i).height;
            ans[i][1] = list.get(i).k;
        }
        return ans;
    }
}
class QueueComparator implements Comparator<People> {
    @Override
    public int compare(People a, People b) {
        int h1 = a.height;
        int h2 = b.height;
        int k1 = a.k;
        int k2 = b.k;
        
        if (k1 < k2) {
           return -1;
        } else if (k1 > k2){
           return 1;
        } else if(h1<h2){
           return -1;
        }
        return 1;
    }
}
class People{
    public int height;
    public int k;
    People(int height, int k) {
        this.height = height;
        this.k = k;
    }
    public int[] toArray() {
        int[] arr = new int[2];
        arr[0] = this.height;
        arr[1] = this.k;
        return arr;
    }
    @Override
    public String toString() {
        return String.format("[%d, %d]", height, k);
    }
}
