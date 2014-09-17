package leetcode;

import java.util.ArrayList;

public class NQueensII {
	private int totalNum = 0;
    
	public int totalNQueens(int n) {
    	if (n > 0) {
	    	ArrayList<Integer> cols = new ArrayList<Integer>(); // cols[i] = c means "ith row and cth column"
	    	placeQueens(cols, n);
    	}
    	return totalNum;
    }
    
    // recursion: temp path, conditions
    private void placeQueens(ArrayList<Integer> cols, int n) {
    	if (cols.size() == n) {
    		totalNum ++;
    	} else {
    		for (int i = 0; i < n; i ++) {
    			if (isValid(i, cols)) { // check it on the fly (no cache...)
    				cols.add(i);
    				placeQueens(cols, n);
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
    
    public static void main(String args[]) {
    	NQueensII solution = new NQueensII();
    	System.out.println(solution.totalNQueens(8));
    }
}
