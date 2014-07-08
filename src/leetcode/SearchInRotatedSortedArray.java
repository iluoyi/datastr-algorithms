package leetcode;

/**
 * Binary search
 * 
 * O(logn), O(1)
 * 
 * @author Yi
 *
 */
public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		int left = 0, right = A.length - 1;
		int mid;
		
		while (left <= right) {
			mid = (left + right) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[left] <= A[mid]) { // can infer that left-mid is monotonic increasing
				if (A[left] <= target && target < A[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (A[mid] < target && target <= A[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		
		return -1;
	}
}
