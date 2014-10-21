package ctci;

public class P1703 {

	public int countFactZeros(int num) {
		int count = 0;
		if (num < 0) {
			return -1;
		} 
		
		int base = 5, tempCount = num / base;
		while (tempCount > 0) {
			count += tempCount;
			base *= 5;
			tempCount = num / base;
		}
		
		return count;
	}
	
	public static void main(String args[]) {
		P1703 solution = new P1703();
		System.out.println(solution.countFactZeros(29));
	}
}
