package leetcode;

/**

 * 
 * 
 * @author yiluo
 *
 */
public class JumpGameII {
	/* DP more time-comsuming
	 * DP: O(n^2)
	 * 
	 * f(i) = min[f(j) + 1]+
	 */
//	public int jump(int[] A) {
//		if (A == null || A.length == 0) return 0;
//		
//		int[] f = new int[A.length];
//		f[0] = 0;
//		
//		int step, min;
//		for (int i = 1; i < A.length; i ++) {
//			min = A.length;
//			for (int j = 0; j < i; j ++) {
//				if (j + A[j] >= i) { // if can reach crt
//					step = f[j] + 1;
//					if (step < min) {
//						min = step;
//					}
//				}
//			}
//			if (min >= A.length) return 0; // cannot reach the end index
//			f[i] = min;
//		}
//		return f[A.length - 1];
//	}
	
	// another greedy algorithm, O(n)
	public int jump(int[] A) {
		int result = 0;
		int crt = 0; // crt reachable range - note: it's a range, not an accurate index
		int next = 0; // reachable range by one more step
		
		for (int i = 0; i < A.length; i ++) {
			if (i > crt) { // if crt range cannot access i
				if (next == crt) 
					return -1; // never reach the end
				else {
					crt = next;
					result ++;
				}
			}
			next = Math.max(next, i + A[i]);
		}
		return result;
	}
	
	public static void main(String args[]) {
		JumpGameII solution = new JumpGameII();
		int[] test = {2, 3, 1, 1, 4};
		System.out.println(solution.jump(test));
	}
}
