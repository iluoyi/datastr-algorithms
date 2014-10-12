package practice;

public class FibonacciSum {
	/**
	 * O(n)
	 * 
	 */
	public int getFibonacciSum(int n) {
		int sum = 0;
		if (n == 1) sum = 1;
		if (n == 2) sum = 2;
		int[] a = {1, 1};
		sum = 2;
		for (int i = 2; i < n; i ++) {
			a[i % 2] = a[0] + a[1];
			sum += a[i % 2];
		}
		return sum;
	}
	
	public int feb_sum(int n) {  
        int sum = 0;  
        for(int i=1;i<=n;i++) {  
            sum += febnaqi(i);
        }  
        return sum;  
    }  
      
    public int febnaqi(int n){  
        if(n ==1 || n == 2) {  
            return 1;  
        }else  
            return febnaqi(n-1) + febnaqi(n-2);
    }  
	
	public static void main(String args[]) {
		FibonacciSum solution = new FibonacciSum();
		System.out.println(solution.getFibonacciSum(5));
		System.out.println(solution.feb_sum(5));
	}
}
