package leetcode;

import java.util.Stack;

public class MaximalRectangle {
		/**
		 * A naive O(n^3) method
		 */
//		public int maximalRectangle(char[][] matrix) {
//	        // Start typing your Java solution below
//	        // DO NOT write main() function
//	        int m = matrix.length;
//	        int n = m == 0 ? 0 : matrix[0].length;
//	        int maxArea = 0;
//	        for(int i = 0; i < m; i++){//row
//	            for(int j = 0; j < n; j++){//col
//	                if(matrix[i][j] == '1'){
//	                    int area = maxRectangle(matrix, i, j);
//	                    if(area > maxArea) maxArea = area;
//	                }
//	            }
//	        }
//	        return maxArea;
//	     }
//		
//	    private int maxRectangle(char[][] matrix, int row, int col) {
//	        int minWidth = Integer.MAX_VALUE;
//	        int maxArea = 0;
//	        for (int i = row; i < matrix.length && matrix[i][col] == '1'; i++) {
//	            int width = 0;
//	            while (col + width < matrix[row].length
//	                    && matrix[i][col + width] == '1') {
//	                width++;
//	            }
//	            if (width < minWidth) {
//	                minWidth = width;
//	            }
//	            int area = minWidth * (i - row + 1);
//	            if (area > maxArea)
//	                maxArea = area;
//	        }
//	        return maxArea;
//	    }

	/**
	 * A better method which reused "Largest Rectangle in Histogram"
	 * 
	 * O(m*n) / O(n) - DP updates height[] for each row
	 * 
	 * 
	 */
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int maxArea = 0;
		int[] height = new int[matrix[0].length]; // n

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				height[j] = (matrix[i][j] == '0') ? 0 : height[j] + 1; // DP
			}
			maxArea = Math.max(largestRectangleArea(height), maxArea);
		}
		return maxArea;
	}
	
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) return 0;
		
		Stack<Integer> index = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i <= height.length; i ++) {
			int crt = (i == height.length) ? -1 : height[i]; // set the last element -1
			while (!index.isEmpty() && crt <= height[index.peek()]) {
				int h = height[index.pop()];
				int w = index.isEmpty() ? i : i - index.peek() - 1;
				max = Math.max(max, h * w);
			}
			index.push(i);
		}
		
		return max;
	}
}
