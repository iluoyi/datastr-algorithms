package leetcode;

public class RemoveDupliFromSortedArray {
	public int removeDuplicates(int[] A) {
        int len = A.length;
        
        if (len > 0) {
            int i = 1, k = 0;
            int crt = 0;
            while (k < len) {
	        	crt = A[k];
	        	k ++;
	        	while (k < len && A[k] == crt) {
	        		k ++;
	        	}
	        	if (k < len) {
	        		A[i] = A[k];
	        		i ++;
	        	}
	        }
	        return i;
        } else {
        	return 0;
        }
    }
	
	public static void main(String args[]) {
		RemoveDupliFromSortedArray solution = new RemoveDupliFromSortedArray();
		int[] A = new int[]{1, 2};//-2, -2, -4, -4, 1, 1, 1, 5
		int len = solution.removeDuplicates(A);
		System.out.println(len);
		
		for (int i = 0; i < len; i ++) {
			System.out.print(A[i] + ", ");
		}
	}
}
