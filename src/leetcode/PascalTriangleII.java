package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (rowIndex >= 0) {
        	for (int i = 0; i <= rowIndex; i ++) {
        		for (int j = i - 1; j > 0; j --) {
        			result.set(j, result.get(j - 1) + result.get(j));
        		}
        		result.add(1);
         	}
        }
        return result;
    }
}
