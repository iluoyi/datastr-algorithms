package leetcode;

public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
    	int[] range = new int[2];
    	range[0] = -1;
    	range[1] = -1;
    	
        if (A != null && A.length != 0) {
        	int right = A.length - 1;
        	int left = 0;
        	int mid = 0, index = -1;
        	
        	while (left <= right) {
        		mid = (left + right) / 2;
        		if (target < A[mid]) {
        			right = mid - 1;
        		} else if (target > A[mid]) {
        			left = mid + 1;
        		} else {
        			index = mid;
        			break;
        		}
        	}
        	
        	if (index != -1) { // meaning that we found it
        		range[0] = index;
        		range[1] = index;
        		while (range[0] - 1 >= 0 && A[range[0] - 1] == target) range[0] --;
        		while (range[1] + 1 < A.length && A[range[1] + 1] == target) range[1] ++;
        	}
        }
        
        return range;
    }
    
    public static void main(String args[]) {
    	SearchForARange solution = new SearchForARange();
    	int[] A = new int[1];
    	A[0] = 1;
    	int[] range = solution.searchRange(A, 1);
    	System.out.println("[" + range[0] + ", " + range[1] + "]");
    }
}
