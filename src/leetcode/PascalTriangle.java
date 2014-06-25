package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if (numRows > 0) {
			
			List<Integer> row = new ArrayList<Integer>(1);
			row.add(1);
			triangle.add(row);

			for (int i = 1; i < numRows; i++) {
				row = new ArrayList<Integer>(i + 1);
				for (int j = 0; j <= i; j++) {
					if (j ==0 || j == i) {
						row.add(1);
					} else {
						row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
					}
				}
				triangle.add(row);
			}
		}
		return triangle;
	}
}
