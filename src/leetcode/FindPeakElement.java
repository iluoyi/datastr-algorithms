package leetcode;

/**
 * Precondition: num[i] != num[i+1]
 * 
 * @author Yi
 *
 */
public class FindPeakElement {
	public int findPeakElement(int[] num) {
		if (num != null) {
			int left = 0, right = num.length - 1;
			
			while (left < right) {
				int mid = left + (right - left) / 2;
				if ((mid == 0 || num[mid -1] < num[mid]) && 
						(mid == num.length - 1 || num[mid] > num[mid + 1])) { // left-good && right-good
					return mid;
				} else if (mid > 0 && num[mid - 1] > num[mid] ){
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			
			return left;
		}
		return -1;
	}
	
	public static void main(String args[]) {
		FindPeakElement solution = new FindPeakElement();
		int[] input = {1};
		System.out.println(solution.findPeakElement(input));
	}
}
