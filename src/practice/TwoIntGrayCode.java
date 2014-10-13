package practice;

public class TwoIntGrayCode {
	
	public boolean isGrayCode(int a, int b) {
		return isFactorialofTwo(a ^ b);
	}
	
	public boolean isFactorialofTwo(int n){
		return n > 0 ? (n & (n - 1)) == 0 : false;
		/**
		 * If true, n should be 1000...00, n-1 should be 111111...11.
		 */
	}
	
	public static void main(String args[]) {
		TwoIntGrayCode solution = new TwoIntGrayCode();
		System.out.println(solution.isGrayCode(1, 3));
	}
}
