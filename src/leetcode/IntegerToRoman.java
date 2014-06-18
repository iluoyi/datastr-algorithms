package leetcode;


public class IntegerToRoman {

	private int[] numList = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10,
			9, 5, 4, 1 };
	private String[] romanList = new String[] { "M", "CM", "D", "CD", "C", "XC",
			"L", "XL", "X", "IX", "V", "IV", "I" };

	public String intToRoman(int num) {
		StringBuffer buf = new StringBuffer("");

		while (num > 0) {
			for (int i = 0; i < numList.length; i ++) {
				if (num >= numList[i]) {
					num -= numList[i];
					buf.append(romanList[i]);
					break;
				}
			}
		}

		return buf.toString();
	}

	public static void main(String args[]) {
		IntegerToRoman solution = new IntegerToRoman();
		System.out.println(solution.intToRoman(3999));
	}
}
