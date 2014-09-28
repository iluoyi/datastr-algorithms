package leetcode;

/**
 * 
 * f[n][i][j] = (f[k][i][j] && f[n-k][i+k][j+k] || f[n-k][i+k][j] && f[k][i][j+n-k])
 * 
 * @author yiluo
 *
 */

public class ScrambleString {
	/**
	 * Method 1: recursion + trim
	 * 
	 */
	// public boolean isScramble(String s1, String s2) {
	// if( s1.length() != s2.length() ){
	// return false;
	// }
	//
	// if( s1.length() == 0 || s1.equals(s2)) {
	// return true;
	// }
	//
	// // this could trim lots of uncessary recursion
	// int[] charSet = new int[26];
	// for (int i = 0; i < s1.length(); i ++) charSet[s1.charAt(i) - 'a'] ++;
	// for (int i = 0; i < s2.length(); i ++) charSet[s2.charAt(i) - 'a'] --;
	// for (int i = 0; i < 26; i ++)
	// if (charSet[i] != 0) return false;
	//
	// for(int i = 1; i <= s1.length() - 1; i++) {
	// String s11 = s1.substring(0, i);
	// String s12 = s1.substring(i);
	// String s21 = s2.substring(0, i);
	// String s22 = s2.substring(i);
	// String s31 = s2.substring(0, s2.length()-i);
	// String s32 = s2.substring(s2.length() - i);
	//
	// if( (isScramble(s11, s21) && isScramble(s12, s22)) ||
	// (isScramble(s11, s32) && isScramble(s12, s31)) ) {
	// return true;
	// }
	// }
	// return false;
	// }

	/**
	 * Method 2: DP
	 * 
	 * O(n^3)
	 * 
	 */
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		if (s1.length() == 0 || s1.equals(s2)) {
			return true;
		}
		
		int n = s1.length();
		
		boolean[][][] f = new boolean[n + 1][n][n];
		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				f[1][i][j] = s1.charAt(i) == s2.charAt(j);
			}
		}
		
		for (int len = 1; len <= n; len ++) {
			for (int i = 0; i <= n - len; i ++) {
				for (int j = 0; j <= n - len; j ++) {
					for (int k = 1; k < len; k ++) {
						if (f[k][i][j] && f[len-k][i+k][j+k] || f[len-k][i+k][j] && f[k][i][j+len-k]) {
							f[len][i][j] = true;
							break;
						}
					}
				}
			}
		}
		
		return f[n][0][0];
	}
}
