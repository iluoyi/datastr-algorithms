package leetcode;


public class SetMatrixZeros {
	public void setZeroes(int[][] matrix) {
    	if (matrix != null && matrix.length > 0) {
	    	int m = matrix.length;
	    	int n = matrix[0].length;
	    	
	    	// constant space
	    	boolean zeroInRow = false;
	    	boolean zeroInColumn = false;
	    	
	    	for (int i = 0; i < m; i ++) {
        		if (matrix[i][0] == 0) {
        			zeroInColumn = true;
        			break;
        		}
	    	}
	    	
	    	for (int j = 0; j < n; j ++) {
        		if (matrix[0][j] == 0) {
        			zeroInRow = true;
        			break;
        		}
	    	}
	    	
	    	// reuse the first row and column
	        for (int i = 1; i < m; i ++) {
	        	for (int j = 1; j < n; j ++) {
	        		if (matrix[i][j] == 0) {
	        			matrix[i][0] = 0;
	        			matrix[0][j] = 0;
	        		}
	        	}
	        }
	        
	        for (int i = 1; i < m; i ++) {
	        	for (int j = 1; j < n; j ++) {
	        		if (matrix[i][0] == 0 || matrix[0][j] == 0) {
	        			matrix[i][j] = 0;
	        		}
	        	}
	        }
	        
	        if (zeroInRow) {
	        	for (int j = 0; j < n; j ++) {
	        		matrix[0][j] = 0;
	        	}
	        }
	        
	        if (zeroInColumn) {
	        	for (int i = 0; i < m; i ++) {
	        		matrix[i][0] = 0;
	        	}
	        }
    	}
    }
    
}
