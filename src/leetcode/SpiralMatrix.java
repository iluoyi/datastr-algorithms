package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return rst;
		
		int beginX = 0, endX = matrix[0].length - 1;
		int beginY = 0, endY = matrix.length - 1;
		
		while (true) {
			// left to right
			for (int j = beginX; j <= endX; j ++) rst.add(matrix[beginY][j]);
			if (++beginY > endY) break;
			// up to bottom
			for (int i = beginY; i <= endY; i ++) rst.add(matrix[i][endX]);
			if (beginX > --endX) break;
			// right to left
			for (int j = endX; j >= beginX; j --) rst.add(matrix[endY][j]);
			if (beginY > --endY) break;
			// bottom to up
			for (int i = endY; i >= beginY; i --) rst.add(matrix[i][beginX]);
			if (++beginX > endX) break;
		}
		
		return rst;
	}
}
