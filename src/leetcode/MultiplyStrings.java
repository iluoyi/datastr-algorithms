package leetcode;

/**
 * 大数相乘
 * 
 * @author yiluo
 *
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) return null;
		
		int len1 = num1.length(), len2 = num2.length();
		int len3 = len1 + len2;
		int[] num3 = new int[len3];
		
		// multiply
		int carry = 0, product = 0;
		int i = 0, j = 0;
		for (i = len1 - 1; i >= 0; i --) {
			carry = 0;
			for (j = len2 - 1; j >= 0; j --) {
				product = carry + num3[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				num3[i + j + 1] = product % 10;
				carry = product / 10;
			}
			num3[i + j + 1] = carry;
		}
		
		// remove 0s (if all 0s, just keep the last one)
		int index = 0;
		while (index < len3 - 1 && num3[index] == 0) index ++;
		
		StringBuilder sb = new StringBuilder();
		while (index < len3) sb.append(num3[index ++]);
		
		return sb.toString();
	}
	
	public static void main(String args[]) {
		MultiplyStrings solution = new MultiplyStrings();
		System.out.println(solution.multiply("12345", "54321"));
	}
}
