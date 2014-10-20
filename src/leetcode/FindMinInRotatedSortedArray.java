package leetcode;

public class FindMinInRotatedSortedArray {
	/**
	 * no duplicates
	 */
	public int findMin(int[] num) {
		if (num != null && num.length > 0) {
			int len = num.length;
			int left = 0, right = len - 1;
			
			int mid = 0;
			while (left <= right) {
				mid = left + (right - left) / 2;
				if ((mid >= 1 && num[mid] < num[mid - 1]) || (mid == 0 && num[mid] <= num[right])) {
					return num[mid];
				} 
				// else - only 3 conditions: l<m<r; m<l; m>r.
				else if (num[mid] > num[right]) { // min exists in right side
					left = mid + 1;
				} else { // min exists in left side
					right = mid - 1;
				} 
			}
		}
		return -1;
	}
	
	public static void main(String args[]) {
		FindMinInRotatedSortedArray solution = new FindMinInRotatedSortedArray();
		int[] num = {1};
		System.out.println(solution.findMin(num));
	}
}
