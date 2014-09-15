package leetcode;

/**
 * DP
 * 
 * @author yiluo
 * 
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		if (m > 0 && n > 0) {
			int[][] steps = new int[m][n];
			steps[0][0] = (obstacleGrid[0][0] == 0 ? 1:0);
			
			for (int j = 1; j < n; j++) {
				steps[0][j] = (steps[0][j - 1] == 1 && obstacleGrid[0][j] == 0? 1:0); // go right
			}
			for (int i = 1; i < m; i++) {
				steps[i][0] = (steps[i - 1][0] == 1 && obstacleGrid[i][0] == 0? 1:0); // go down
			}
			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					if (obstacleGrid[i][j] == 0)
						steps[i][j] = steps[i - 1][j] + steps[i][j - 1];
					else 
						steps[i][j] = 0;
				}
			}
			return steps[m - 1][n - 1];
		} else {
			return 0;
		}
	}
	
	public static void main(String args[]) {
		int[][] map = new int[][]{{0, 1}};
		UniquePathsII solution = new UniquePathsII();
		System.out.println(solution.uniquePathsWithObstacles(map));
	}
}
