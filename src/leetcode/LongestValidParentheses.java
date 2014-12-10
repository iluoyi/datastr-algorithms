package leetcode;

import java.util.Stack;

public class LongestValidParentheses {
	/**
	 * use a stack 
	 * O(n) / O(n)
	 */
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) return 0;

		int maxLen = 0;
		Stack<Integer> stack = new Stack<Integer>(); // just hold indexes of '('s
		int index = -1; // indicates the index of last ')'
		
		for (int i = 0; i < s.length(); i ++) {
			if (s.charAt(i) == '(') { // push left '('
				stack.push(i);
			} else {
				if (stack.isEmpty()) { // move index to crt place
					index = i;
				} else { // if matched
					stack.pop(); // pop out the top element
					if (stack.isEmpty()) {
						maxLen = Math.max(maxLen, i - index); // a good match
					} else {
						maxLen = Math.max(maxLen, i - stack.peek()); // remaining many '('s
					}
				}
			}
		}
		
		return maxLen;
 	}
	
	public static void main(String args[]) {
		LongestValidParentheses solution = new LongestValidParentheses();
		System.out.println(solution.longestValidParentheses("(()"));
	}
}
