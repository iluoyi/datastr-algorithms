package leetcode;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		if (n > 0) {
			int[][] result = new int[n][n];
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j < n; j ++) {
					result[i][j] = 0;
				}
			}
			
			int rowStep = 0, colStep = 1;
			int crtRow = 0, crtCol = 0;
			
			for (int i = 1; i <= n * n; i ++) {
				result[crtRow][crtCol] = i;
				crtRow += rowStep;
				crtCol += colStep;
				if (crtRow > n - 1 || crtRow < 0 ||
						crtCol > n - 1 || crtCol < 0 ||
							result[crtRow][crtCol] != 0) {
					crtRow -= rowStep;
					crtCol -= colStep;
					if (rowStep == 0 && colStep == 1) {
						rowStep = 1;
						colStep = 0;
					} else if (rowStep == 1 && colStep == 0) {
						rowStep = 0;
						colStep = -1;
					} else if (rowStep == 0 && colStep == -1) {
						rowStep = -1;
						colStep = 0;
					} else if (rowStep == -1 && colStep == 0) {
						rowStep = 0;
						colStep = 1;
					}
					crtRow += rowStep;
					crtCol += colStep;
				}
			}
			return result;
		} else {
			return new int[0][];
		}
	}
	
	public static void main(String args[]) {
		SpiralMatrixII solution = new SpiralMatrixII();
		int[][] result = solution.generateMatrix(0);
		for (int i = 0; i < result.length; i ++) {
			for (int j = 0; j < result[0].length; j ++) {
				System.out.print(result[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
