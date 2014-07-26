package leetcode;

public class ReverseWordsInString {
	public String reverseWords(String testStr) {
		if (testStr == null)
			return null;

		String[] terms = testStr.trim().split(" +"); // O(n)
		int len = terms.length;

		StringBuilder result = new StringBuilder("");
		int i;
		for (i = len - 1; i > 0; i --) {
			result.append(terms[i]);
			result.append(" ");
		}
		result.append(terms[i]);
		return result.toString();
	}

	public static void main(String args[]) {
		ReverseWordsInString solution = new ReverseWordsInString();
		System.out.println(solution.reverseWords("    b     a gsf safde "));
	}
}
