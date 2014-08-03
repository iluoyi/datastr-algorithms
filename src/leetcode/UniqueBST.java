package leetcode;

import java.util.Arrays;
/**
 * DP: O(n)
 * 
 * @author yiluo
 *
 */
public class UniqueBST {
	public int numTrees(int n) {
        if (n < 0) {
            return 0;
        } else {
            int[] a = new int[n + 1];
            Arrays.fill(a, 0);
            a[0] = 1; // intial value
            a[1] = 1;

			for (int i = 2; i <= n; ++i) {
				for (int k = 1; k <= i; ++k) // root enum
					a[i] += a[k - 1] * a[i - k];
			}
			
            return a[n];
        }
    }
}
