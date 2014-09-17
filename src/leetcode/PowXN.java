package leetcode;

/**
 * O(logn) by recursion
 * 
 * @author CSE User
 *
 */
public class PowXN {
	public double pow(double x, int n) {
		if (n == 0) return 1;
		if (n == 1) return x;
		
		boolean negative = false;
		if (n < 0) {
			negative = true;
			n *= -1;
		}
		
		int t = n / 2;
		int r = n - t * 2;
		
		double temp1 = pow(x, t);
		double temp2 = pow(x, r);
		
		if (negative) {
			return 1 / (temp1 * temp1 * temp2);
		} else {
			return temp1 * temp1 * temp2;
		}
	}
	
	public static void main(String args[]) {
		PowXN solution = new PowXN();
		System.out.println(solution.pow(2.0, 5));
	}
}
