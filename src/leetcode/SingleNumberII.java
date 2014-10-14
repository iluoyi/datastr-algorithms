package leetcode;

public class SingleNumberII {
	public int singleNumber(int[] A) {
        int len = A.length;
        int[] bitSum = new int[32];
        int result = 0;
        
        for (int i = 0; i < 32; i ++) {//for each bit
        	for (int j = 0; j < len; j ++) {//for each integer
        		bitSum[i] += ((A[j] >> i) & 1);
        	}
        	result = result | ((bitSum[i] % 3) << i);
        }
        
        return result;
    }
	
	/**
	 * This one is Diao Bao Le!
	 */
	public int singleNumber(int A[], int n) {
	    int ones = 0, twos = 0, xthrees = 0;
	    for(int i = 0; i < n; ++i) {
	        twos |= (ones & A[i]);
	        ones ^= A[i];
	        xthrees = ~(ones & twos);
	        ones &= xthrees;
	        twos &= xthrees;
	    }

	    return ones;
	}
}
