package leetcode;

public class TrappingRainWater {
    public int trap(int[] A) {
        int max = 0, maxIndex = 0;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] > max) {
        		max = A[i];
        		maxIndex = i;
        	}
        }

        int result = 0, temp = 0;
        for (int i = 0; i < maxIndex; i ++) {
        	if (A[i] > temp) {
        		temp = A[i];
        	} else {
        		result += (temp - A[i]);
        	}
        }
        
        temp = 0;
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
 