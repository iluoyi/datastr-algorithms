package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1. sort
 * 2. insert one by one
 * 
 * @author yiluo
 *
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		
		Collections.sort(intervals, new IntervalComparator());
		
		ArrayList<Interval> rst = new ArrayList<Interval>();
		Interval prev = intervals.get(0), crt = null;
		
		for (int i = 1; i < intervals.size(); i ++) {
			crt = intervals.get(i);
			if (crt.start <= prev.end) { // merge them
				prev.end = Math.max(prev.end, crt.end);
			} else { // move to the crt
				rst.add(prev);
				prev = crt;
			}
		}
		rst.add(prev);
		return rst;
	}
	
	private class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
	}
}
