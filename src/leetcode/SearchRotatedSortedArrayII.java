package leetcode;

/**
 * Binary search has the same complexity as naive sequential search
 * 
 * O(n), O(1)
 * 
 * @author Yi
 *
 */
public class SearchRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		int left = 0, right = A.length - 1;
		int mid;
		
		while (left <= right) {
			mid = (left + right) / 2;
			if (A[mid] == target) {
				return true;
			} else if (A[left] < A[mid]) {
				if (A[left] <= target && target < A[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (A[left] > A[mid]) {
				if (A[mid] < target && target <= A[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				left ++; // skip duplicates
			}
		}
		
		return false;
	}
	
//	public boolean search(int[] A, int target) {
//        for (int i = 0; i < A.length; i ++) {
//            if (A[i] == target) {
//                return true;
//            }
//        }
//        return false;
//    }
}
