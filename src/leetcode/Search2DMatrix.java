package leetcode;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix != null && matrix.length != 0) {
			int m = matrix.length;
			int n = matrix[0].length;
			
			int head = 0;
			int tail = m * n - 1;
			int mid, guy;
			
			while (head <= tail) {
				mid = (head + tail) / 2;
				guy = matrix[mid / n][mid % n];
				if (target < guy) {
					tail = mid - 1;
				} else if (target > guy) {
					head = mid + 1;
				} else {
					return true;
				}
			}
		}
		
		return false;
	}
}
 