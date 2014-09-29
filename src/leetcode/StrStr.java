package leetcode;

public class StrStr {
	/**
	 * Brute force O(mn)
	 */
	public String strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return null;
		}
		int i, j;
		for (i = 0; i < haystack.length() - needle.length() + 1; i++) { // m
			for (j = 0; j < needle.length(); j++) { // n
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == needle.length()) {
				return haystack.substring(i);
			}
		}
		return null;
	}

	/**
	 * Can consider KMP
	 */

}