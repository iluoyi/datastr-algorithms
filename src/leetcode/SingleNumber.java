package leetcode;

public class SingleNumber {
	public int singleNumber(int[] A) {
        int x = 0;
        for (int i = 0; i < A.length; i ++) {
            x ^= A[i]; // XOR
        }
        return x;
    }
	/**
	 * Or use a HashMap
	 */
}
