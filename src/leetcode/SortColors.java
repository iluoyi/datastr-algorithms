package leetcode;

public class SortColors {
	/**
	 * Two pass - counting sort
	 * @param A
	 */
	public void sortColors(int[] A) {
        int[] C = new int[3];
        for (int i = 0; i < C.length; i++) {
        	C[i] = 0;
        }
        
        for (int i = 0; i < A.length; i++) {
        	C[A[i]] ++;
        }
        
        int count = 0;
        for (int i = 0; i < C.length; i++) {
        	for (int j = 0; j < C[i]; j++) {
            	A[count++] = i;
            }
        }
    }
	
	/**
	 * One pass - quick sort idea
	 * 
	 */
	// int r, w, b
	// while (w<=b) {
	//    A[w] == 0 -> swap(A[r++], A[w++]);
	//    A[w] == 1 -> w++;
	//    A[w] == 2 -> swap(A[w++], A[b--]);
}
