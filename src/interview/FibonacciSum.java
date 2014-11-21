package interview;

public class FibonacciSum {
	/**
	 * O(n)
	 * 
	 */
	public int getFibonacciSum(int n) {
		int sum = 0;
		if (n == 0) sum = 1;
		if (n == 1) sum = 2;
		int[] a = {1, 1};
		sum = 2;
		for (int i = 2; i <= n; i ++) {
			a[i % 2] = a[0] + a[1];
			sum += a[i % 2];
		}
		return sum;
	}
	
	/**
	 * O(n)
	 * 
	 * @param n
	 * @return
	 */
	public int febonacci(int n) {
		if (n == 0 || n == 1)
			return 1;
		else  {
			int[] f = { 1, 1 };
			for (int i = 2; i <= n; i ++) 
				f[i % 2] = f[0] + f[1];
			return f[n % 2];
		}
	}
	
	public int feb_sum(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum += feb_num(i);
		}
		return sum;
	}
      
	/**
	 * ~~= O(2^n)
	 * 
	 * @param n
	 * @return
	 */
	public int feb_num(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else
			return feb_num(n - 1) + feb_num(n - 2);
	}
	
	public static void main(String args[]) {
		FibonacciSum solution = new FibonacciSum();
		System.out.println(solution.getFibonacciSum(5));
		System.out.println(solution.feb_sum(5));
	}
}
