package leetcode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        String left = "([{";
        String right = ")]}";
        
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
        	if (c == '(' || c == '[' || c == '{') {
        		stack.push(c);
        	} else {
        		if (!stack.isEmpty() && right.charAt(left.indexOf(stack.peek())) == c) {
        			stack.pop();
        		} else {
        			return false;
        		}
        	}
        }
        
        return stack.isEmpty();
    }
}
