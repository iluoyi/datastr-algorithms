package leetcode;

/**
 * DP: O(n^2) time / O(n) space
 * 
 * @author yiluo
 *
 */
public class UniqueBST {
	public int numOfTrees(int n) {
        if (n <= 0) {
            return 0;
        } else {
            int[] a = new int[n + 1];
            a[0] = 1; // intial value
            a[1] = 1;

			for (int i = 2; i <= n; ++i) {
				for (int k = 0; k < i; ++k) // root enum
					a[i] += a[k] * a[i - k - 1];
			}
			
            return a[n];
        }
    }
	
	public static void main(String args[]) {
		UniqueBST solution = new UniqueBST();
		System.out.println(solution.numOfTrees(-1));
		System.out.println(solution.numOfTrees(0));
		System.out.println(solution.numOfTrees(1));
		System.out.println(solution.numOfTrees(2));
		System.out.println(solution.numOfTrees(3));
		System.out.println(solution.numOfTrees(4));
		System.out.println(solution.numOfTrees(5));
	}
}
