package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * O(n)
 * 
 * @author yiluo
 *
 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals == null || newInterval == null) return intervals;
		
		ArrayList<Interval> rst = new ArrayList<Interval>();
		
		boolean inserted = false;
		for (Interval crt : intervals) {
			if (!inserted) { // newInterval has been inserted properly
				if (newInterval.end < crt.start) { // 1. before
					rst.add(newInterval);
					rst.add(crt);
					inserted = true;
				} else if (newInterval.start <= crt.end){ // 2. startBeforeEnd, merge overlapped intervals
					newInterval.start = Math.min(newInterval.start, crt.start);
					newInterval.end = Math.max(newInterval.end, crt.end);
				} else { // 3. startAfterEnd
					rst.add(crt);
				}
			} else {
				rst.add(crt);
			}
		}
		
		if (!inserted) {
			rst.add(newInterval);
		}
		
		return rst;
	}
}
