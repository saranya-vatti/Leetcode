import java.math.*;
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1) return intervals;
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start > i2.start ? 1 : (i1.start == i2.start ? 0 : -1);
            }
        });
        res = intervals;
        int i=0;
        while(i<res.size()-1) {
            /*StringBuilder str = new StringBuilder("");
            for(int j=0;j<res.size();j++) {
                str.append("[");
                str.append(res.get(j).start);
                str.append(",");
                str.append(res.get(j).end);
                str.append("],");
            }
            System.out.println(str.toString());
            System.out.println("i = " + i);*/
            Interval curr = res.get(i);
            Interval next = res.get(i+1);
            if(next.start <= curr.end) {
                res.add(i, new Interval(curr.start, Math.max(curr.end, next.end)));
                res.remove(i+1);
                res.remove(i+1);
            } else {
                i++;
            }
        }
        return res;
    }
}