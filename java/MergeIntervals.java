import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals == null) {
            return res;
        }
        int n = intervals.size();
        if (n == 0) {
            return res;
        }
        Comparator<Interval> IntervalComparator
            = new Comparator<Interval>() {
                @Override
                public int compare(Interval interval1, Interval interval2) {
                    if (interval1.start != interval2.start) {
                        return interval1.start - interval2.start;
                    }
                    return interval1.end - interval2.end;
                }
            };
        Collections.sort(intervals, IntervalComparator);
        int lastStart = intervals.get(0).start;
        int lastEnd = intervals.get(0).end;
        for (int i = 0; i < n; ++i) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            if (start > lastEnd) {
                res.add(new Interval(lastStart, lastEnd));
                lastStart = start;
            }
            lastEnd = Math.max(lastEnd, end);
        }
        // don't miss the last interval
        res.add(new Interval(lastStart, lastEnd));
        return res;
    }
}
