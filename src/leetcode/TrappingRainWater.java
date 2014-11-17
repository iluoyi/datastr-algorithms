package leetcode;

public class TrappingRainWater {
	/**
	 * O(n) / O(1)
	 * 
	 * @param A
	 * @return
	 */
    public int trap(int[] A) {
        int max = 0, maxIndex = 0;
        // find the highest one
        for (int i = 0; i < A.length; i++) {
        	if (A[i] > max) {
        		max = A[i];
        		maxIndex = i;
        	}
        }

        int result = 0, temp = 0;
        // process the left side
        for (int i = 0; i < maxIndex; i ++) {
        	if (A[i] > temp) {
        		temp = A[i];
        	} else {
        		result += (temp - A[i]);
        	}
        }
        
        temp = 0;
        // process the right side
        for (int i = A.length - 1; i > maxIndex; i --) {
        	if (A[i] > temp) {
        		temp = A[i];
        	} else {
        		result += (temp - A[i]);
        	} 
        }
        
        return result;
    }
}
 