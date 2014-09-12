package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<List<String>>();
        if (s == null) {
        	return list;
        }
        
        ArrayList<String> result = new ArrayList<String>();
        find(list, result, s);
        
        return list;
    }
	
	/**
	 * DFS
	 */
	private void find(List<List<String>> list, ArrayList<String> result, String s) {
		if (s.length() == 0) {
			list.add(new ArrayList<String>(result));
		} else {
			for (int i = 1; i <= s.length(); i ++) {
				if (isPalindrome(s.substring(0, i))) {
					result.add(s.substring(0, i));
					find(list, result, s.substring(i));
					result.remove(result.size() - 1); // backtracking
				}
			}
		}
	}
	
	private boolean isPalindrome(String s) {
		int len = s.length();
		for (int i = 0; i < len / 2; i ++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {  
        System.out.println(new PalindromePartitioning().partition("aabaa"));  
    }  
}
