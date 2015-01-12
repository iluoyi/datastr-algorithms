package leetcode;

/**
 * 
 * 1. DP: O(n^2) / O(n^2)
 * 
 * 2. Manacher's Algorithm: O(n) / O(n) 
 * 
 * @author yiluo
 *
 */
public class LongestPalindromicSubstring {
	/**
	 * DP
	 * f[i][j] = f[i+1][j-1] && s[i] == s[j]
	 * 
	 */
	public String longestPalindrome(String s) {
		if (s.length() <= 1) return s;
		
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		for (int i = 0; i < len; i ++) {
			for (int j = 0; j < len; j ++) {
				if (i == j || i > j) dp[i][j] = true; 
				else dp[i][j] =false;
			}
		}	
		int maxLen = 0;
		int left = 0, right = 0;
		for (int k = 1; k < len; k ++) { // the length of substrings
			for (int i = 0; i < len - k; i ++) {
				int j = i + k;
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1];
				}
				if (dp[i][j] && k > maxLen) {
					maxLen = k;
					left = i;
					right = j;
				}
			}
		}
		return s.substring(left, right + 1);
	}
	
	/**
	 * Manacher's Algorithm: O(n) / O(n)
	 * 
	 */
	
	public static void main(String args[]) {
		LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
		System.out.println(solution.longestPalindrome("babcbabcbaccba"));
	}
}
