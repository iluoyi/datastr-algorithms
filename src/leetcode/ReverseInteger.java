package leetcode;

public class ReverseInteger {

	/**
	 * No stack here, just go ahead!
	 * 
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		int result = 0;
		int digit = 0;
		// int sign = (x < 0) ? -1:1;
		while (x != 0) {
			digit = x % 10; // we can get negative digits here.
			// System.out.println(digit);
			result = result * 10 + digit;
			x = x / 10;
		}
		return result;// * sign;
	}

	public static void main(String args[]) {
		ReverseInteger solution = new ReverseInteger();
		System.out.println(solution.reverse(-123));
	}
}
