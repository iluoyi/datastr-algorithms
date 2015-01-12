package interview;


/**
 * Microsoft - onsite 1/6/2015
 * 
 * 
	Write an efficient algorithm that searches for a value in an n x m table (two-dimensional array). 
	This table is sorted along the rows and columns ¡ª that is,
	
	Table[i][j] ¡Ü Table[i][j + 1], 
	Table[i][j] ¡Ü Table[i + 1][j]
**/
public class SearchSorted2DMatrix {
	/**
	 * O(n)
	 */
	public boolean search(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
			return false;
		else {
			int m = matrix.length, n = matrix[0].length;
			if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
			else {
				int row = m - 1, col = 0;
				while (row >= 0 && col <= n - 1) {
					if (target > matrix[row][col]) {
						col ++; // to right
					} else if (target < matrix[row][col]) {
						row --;
					} else {
						return true;
					}
				}
			}
			return false;
		}
	}
}
