/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// [[6,9],[1,3]]; [2,5] : [[2,5],[6,9],[1,3]]
// [[6,9],[1,3]]; [1,10] : [[1,10]]
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //if(intervals.size() == 0) return intervals;
        boolean inserted = false;
        for(int i=0;i<intervals.size();) {
            Interval currInterval = intervals.get(i);
            int cs = currInterval.start;
            int ce = currInterval.end;
            int ns = newInterval.start;
            int ne = newInterval.end;
            if(cs<ns && ce<ns) {
                i++;
            } else if(ns<cs && ne<cs) {
                intervals.add(i, newInterval);
                inserted = true;
                break;
            } else if(ns <= cs && cs <= ne && ne <= ce) {
                newInterval = new Interval(ns, ce);
                intervals.remove(i);
            } else if(cs <= ns && ne <= ce) {
                return intervals;
            } else if(cs <= ns && ns <= ce && ce <= ne) {
                newInterval = new Interval(cs, ne);
                intervals.remove(i);
            } else {
                // ns <= cs && ce <= ne
                intervals.remove(i);
            }
        }
        if(!inserted) intervals.add(newInterval);
        return intervals;
    }
}