package leetcode;

// simulation

public class AddBinary {
	public String addBinary(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		int len = aLen > bLen ? aLen : bLen;
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();
		
		int carry = 0;
		int val = 0, x, y;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < len; i ++) {
			x = i < aLen ? a.charAt(i) - '0' : 0;
			y = i < bLen ? b.charAt(i) - '0' : 0;
			val = (x + y + carry) % 2;
			carry = (x + y + carry) / 2;
			result.insert(0, val);
		}
		if (carry == 1) result.insert(0, '1');
		
		return result.toString();
	}
	
	public static void main(String args[]) {
		AddBinary solution = new AddBinary();
		System.out.println(solution.addBinary("101", "1110"));
	}
}
