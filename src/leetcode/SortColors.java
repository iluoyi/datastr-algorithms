package leetcode;

public class SortColors {
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
}
