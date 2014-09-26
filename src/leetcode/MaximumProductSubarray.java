package leetcode;

/**
 * DP
 * 
 * min * A[i] might be the new maximum value (-4 * -6 = 24)
 * 
 * @author yiluo
 *
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		if (A == null || A.length == 0) return 0;
		
		int[] f = new int[A.length]; // crt max
		int[] g = new int[A.length]; // crt min
		f[0] = A[0];
		g[0] = A[0];
		int result = A[0];
		for (int i = 1; i < A.length; i ++) {
			f[i] = Math.max(Math.max(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
			g[i] = Math.min(Math.min(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
			result = Math.max(result, f[i]);
		}
		return result;
 	}
}
