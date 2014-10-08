package leetcode;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * 1. Integer.MIN = -2^31 2. Integer.MAX = 2^31 - 1 还有一位用来当符号了
 * 
 * @author yiluo
 *
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		long a = Math.abs((long) dividend); // use long to avoid overflow
		long b = Math.abs((long) divisor);
		int ans = 0;

		while (a >= b) {
			int shift = 0;
			while ((b << shift) <= a) { // (* 2^shift)
				shift++;
			}
			ans += 1 << (shift - 1);
			a = a - (b << (shift - 1));
		}
		return (dividend > 0 ^ divisor > 0) ? -ans : ans; // XOR
	}
	
	public static void main(String args[]) {
		DivideTwoIntegers solution = new DivideTwoIntegers();
		System.out.println(solution.divide(73, 5));
	}
}
