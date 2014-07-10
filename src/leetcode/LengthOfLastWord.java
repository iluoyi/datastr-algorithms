package leetcode;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null)
			return 0;
		
		int index = s.length() - 1;
		int len = 0;

		while (index >= 0 && s.charAt(index) == ' ') {
			index--;
		}
		while (index >= 0 && s.charAt(index) != ' ') {
			index--;
			len++;
		}
		
		return len;
	}
}
