package leetcode;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> mins = new Stack<Integer>();
	
	public void push(int x) {
		stack.push(x);
		if (mins.isEmpty() || x <= mins.peek()) {
			mins.push(x);
		}
	}

	public void pop() {
		if (!stack.isEmpty()) {
			if (stack.peek().equals(mins.peek()))
				mins.pop();
			stack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return mins.peek();
	}
	
	public static void main(String args[]) {
		MinStack stack = new MinStack();
		stack.push(-2);
		stack.push(0);
		stack.push(-1);
		System.out.println(stack.getMin());
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.getMin());
	}
}
