package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 7/22/18
 *
 * https://leetcode.com/problems/insert-interval/description/
 */
public class InsertInterval57 {

    private List<MergeIntervals.Interval> intervals;

    public InsertInterval57() {
        intervals = new ArrayList<>();
        intervals.add(new MergeIntervals.Interval(1,2));
        intervals.add(new MergeIntervals.Interval(3,5));
        intervals.add(new MergeIntervals.Interval(6,7));
        intervals.add(new MergeIntervals.Interval(8,10));
        intervals.add(new MergeIntervals.Interval(12,16));
    }

    private void insert(MergeIntervals.Interval interval) {
        intervals.add(interval);

        Collections.sort(intervals);

        List<MergeIntervals.Interval> merged = new ArrayList<>();
        MergeIntervals.Interval pre = intervals.get(0);
        for(int i = 1; i<intervals.size(); i++) {
            MergeIntervals.Interval cur = intervals.get(i);
            if(cur.start > pre.end) {
                merged.add(pre);
                pre = cur;
            } else {
                pre = new MergeIntervals.Interval(pre.start, Math.max(pre.end, cur.end));
            }
        }
        merged.add(pre);

        intervals.clear();
        intervals.addAll(merged);
    }

    public static void main(String[] args) {
        InsertInterval57 ins = new InsertInterval57();
        ins.insert(new MergeIntervals.Interval(4, 8));
        System.out.println(ins.intervals);
    }

}
