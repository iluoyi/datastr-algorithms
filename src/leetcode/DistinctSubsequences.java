package leetcode;

/**
 * DP
 * 
 * O(m*n) / O(n^2) -> O(n) by only one Array
 * 
 * f[i][j] = f[i-1][j] + (f[i-1][j-1] if char[i-1]=char[j-1])
 * 
 * @author yiluo
 *
 */
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if (S == null || T == null) {
			return 0;
		}
		
		int[][] f = new int[S.length() + 1][T.length() + 1];
		
		for (int i = 0; i <= S.length(); i ++) {
			f[i][0] = 1;
		}
		
		for (int i = 1; i <= S.length(); i ++) {
			for (int j = 1; j <= T.length(); j ++) {
				f[i][j] = f[i - 1][j];
				if (S.charAt(i - 1) == T.charAt(j - 1)) { // if the crt char contributes
					f[i][j] += f[i - 1][j - 1];
				}
			}
		}
		
		return f[S.length()][T.length()];
	}
}
