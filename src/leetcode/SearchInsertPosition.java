package leetcode;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        int head = 0;
        int tail = A.length - 1;
        int mid = 0;
        
        while (head <= tail) {
        	mid = (head + tail) / 2;
        	if (A[mid] < target) {
        		head = mid + 1;
        	} else if (A[mid] > target) {
        		tail = mid - 1;
        	} else {
        		return mid;
        	}
        }
        
        return head; // if not found, just return the head as the index
    }
	
	public static void main(String args[]) {
		SearchInsertPosition solution = new SearchInsertPosition();
		int[] A = {1};
		System.out.println(solution.searchInsert(A, 2));
	}
}
