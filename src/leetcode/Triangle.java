package leetcode;

import java.util.List;

/**
 * Time: O(n^2), space: O(n)
 * 
 * @author yiluo
 *
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        
        int n = triangle.size();
        int[] tempRow = new int[n]; // which has the same number of elements as the last row 
        
        for (int i = 0; i < n; i ++)
        	tempRow[i] = triangle.get(n - 1).get(i);
        
        for (int i = n - 2; i >= 0; i --) {
        	for (int j = 0; j < i + 1; j ++) {
        		tempRow[j] = Math.min(tempRow[j], tempRow[j + 1]) + triangle.get(i).get(j);
        	}
        }
        
        return tempRow[0];
    }
}
