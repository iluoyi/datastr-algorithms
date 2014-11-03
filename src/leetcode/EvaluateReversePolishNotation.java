package leetcode;

import java.util.Stack;

/**
 * Use a stack
 */

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		String operators = "+-*/";

		for (String token : tokens) {
			if (!operators.contains(token)) {
				s.push(Integer.parseInt(token));
			} else {
				int a = s.pop();
				int b = s.pop();
				if (token.equals("+")) {
					s.push(b + a);
				} else if (token.equals("-")) {
					s.push(b - a);
				} else if (token.equals("*")) {
					s.push(b * a);
				} else {
					s.push(b / a);
				}
			}
		}
		return s.pop();
	}
}
