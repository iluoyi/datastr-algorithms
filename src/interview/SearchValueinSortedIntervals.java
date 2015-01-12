package interview;

import leetcode.Interval;

public class SearchValueinSortedIntervals {
	int getIntervalIndex(Interval[] intervals, int target) {
		int index = -1;
		int left = 0, right = intervals.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target < intervals[mid].start) {
				if (mid > 0 && target >= intervals[mid - 1].start) {
					index = mid - 1;
					break;
				} else if (mid == 0) {
					index = mid;
					break;
				} else {
					right = mid - 1;
				}
			} else if (target > intervals[mid].start) {
				if (mid < intervals.length - 1
						&& target < intervals[mid + 1].start
						|| mid == intervals.length - 1) {
					index = mid;
					break;
				} else {
					left = mid + 1;
				}
			} else {
				index = mid;
				break;
			}
		}
		if (index != -1 && target >= intervals[index].start
				&& target <= intervals[index].end) {
			return index;
		} else {
			return -1;
		}
	}

	public static void main(String args[]) {
		SearchValueinSortedIntervals solution = new SearchValueinSortedIntervals();
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(5, 12);
		intervals[1] = new Interval(18, 23);
		intervals[2] = new Interval(25, 30);
		System.out.println(solution.getIntervalIndex(intervals, 7));
	}
}
