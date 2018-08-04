package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 7/22/18
 *
 * https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeIntervals {

    public static class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override public String toString() {
            return "Interval{" + "start=" + start + ", end=" + end + '}';
        }

        @Override public int compareTo(Interval o) {
            if(this.start != o.start)
                return this.start - o.start;
            return this.end - o.end;
        }
    }

    // Solution - https://www.programcreek.com/2012/12/leetcode-merge-intervals/
    private List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if(intervals == null || intervals.isEmpty())
            return result;

        Collections.sort(intervals);

        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start > pre.end) {
                result.add(pre);
                pre = curr;
            } else {
                pre = new Interval(pre.start, Math.max(pre.end, curr.end));
            }
        }
        result.add(pre);

        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(15,18));
        intervals.add(new Interval(8,10));


        MergeIntervals mi = new MergeIntervals();
        List<Interval> merged = mi.merge(intervals);
        System.out.println(merged);
    }
}
