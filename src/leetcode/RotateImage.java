package leetcode;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int temp = 0;
		
        // overturn to the diagonal
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		// overturn left-right
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = temp;
			}
		}
    }
	
}
 