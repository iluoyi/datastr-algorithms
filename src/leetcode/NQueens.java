package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<String[]> solveNQueens(int n) {
    	List<String[]> results = new ArrayList<String[]>();
    	if (n <= 0) return results;
    	
    	ArrayList<Integer> cols = new ArrayList<Integer>(); // cols[i] = c means "ith row and cth column"
    	placeQueens(results, cols, n);
    	return results;
    }
    
    // recursion: result, temp path, conditions
    private void placeQueens(List<String[]> results, ArrayList<Integer> cols, int n) {
    	if (cols.size() == n) {
    		// terminate condition
    		results.add(drawMap(cols));
    	} else {
    		for (int i = 0; i < n; i ++) {
    			if (isValid(i, cols)) { // check it on the fly (no cache...)
    				cols.add(i);
    				placeQueens(results, cols, n);
    				cols.remove(cols.size() - 1); // back tracking
    			}
    		}
    	}
    }
    
    // this is low efficient
    private boolean isValid(int col, ArrayList<Integer> cols) {
    	int num = cols.size();
    	for (int row = 0; row < num; row ++) {
    		if (cols.get(row) == col) return false;
    		if (cols.get(row) - col == row - num) return false; // left-up-to-right-down
    		if (cols.get(row) + row == col + num) return false;
    	}
    	return true;
    }
    
    private String[] drawMap(ArrayList<Integer> cols) {
    	int n = cols.size();
    	String[] map = new String[n];
    	
    	StringBuilder builder = null;
    	for (int i = 0; i < n; i ++) { // row
    		builder = new StringBuilder();
    		for (int j = 0; j < n; j ++) { // col
    			if (j == cols.get(i)) {
    				builder.append('Q');
    			} else {
    				builder.append('.');
    			}
    		}
    		map[i] = builder.toString();
    	}
    	
    	return map;
    }
    
    public static void main(String args[]) {
    	NQueens solution = new NQueens();
    	List<String[]> results = solution.solveNQueens(8);
    	for (String[] strArray : results) {
    		for (int i = 0; i < strArray.length; i ++) {
    			System.out.println(strArray[i]);
    		}
    		System.out.println();
    	}
    }
}
