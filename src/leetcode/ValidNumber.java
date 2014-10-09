package leetcode;

public class ValidNumber {
	public boolean isNumber(String s) {
		if (s == null)
			return false;
		s = s.trim(); // remove spaces from the head and the tail
		int len = s.length();
		if (len == 0) return false;
		int i = 0, e = len - 1;
		// skip leading +/-
		if (s.charAt(i) == '+' || s.charAt(i) == '-')
			i++;
		boolean num = false; // if the previous index is a digit
		boolean dot = false; // if the string contains a '.'
		boolean exp = false; // if the string contains a 'e'
		while (i <= e) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = true;
			} else if (c == '.') {
				if (exp || dot) // extra '.' or one 'e' before
					return false;
				dot = true;
			} else if (c == 'e') {
				if (exp || num == false) // it's ok to have '.' before
					return false;
				exp = true;
				num = false;
			} else if (c == '+' || c == '-') { // can only be the sign associated with 'e'
				if (s.charAt(i - 1) != 'e')
					return false;
			} else {
				return false;
			}
			i++;
		}
		return num;
	}
	
	public static void main(String args[]) {
		ValidNumber solution = new ValidNumber();
		System.out.println(solution.isNumber(" "));
	}
}
