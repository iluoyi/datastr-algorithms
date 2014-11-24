package leetcode;

/**
 * NineChapter is not that efficient
 * 
 * We use DP
 * 
 * 1. one auxiliary matrix
 * 2. cut[i + 1] = min(cut[i + 1], cut[j] + 1)
 * 
 * @author CSE User
 *
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int len = s.length();
        int[] cut = new int[len + 1];
        boolean[][] pMatrix = new boolean[len][len];
        
        for (int i = 0; i <= len; i ++) {
        	cut[i] = i; // cut number = the number of characters (will -1 finally)
        }
        
        // O(n^2)
        for (int i = 0; i < len ; i ++) {
        	for (int j = 0; j <= i; j ++) {
        		if (s.charAt(i) == s.charAt(j) && 
        				(i - j < 2 || pMatrix[j + 1][i - 1] == true)) {
        			pMatrix[j][i] = true; // j to i is palindrome
        			cut[i + 1] = Math.min(cut[i + 1], cut[j] + 1);
        		}
        	}
        }
        
        return cut[len] - 1;
    }
    
    public static void main(String args[]) {
    	PalindromePartitioningII solution = new PalindromePartitioningII();
    	System.out.println(solution.minCut("aabaa"));
    }
}
