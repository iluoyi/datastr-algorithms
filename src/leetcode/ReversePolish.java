package leetcode;

public class ReversePolish {
	private class Node {
		String token;
		Node parent, left, right;
		
		Node(String str) {
			this.token = str;
			parent = null;
			left = null;
			right = null;
		}
	}
	
	Node root = null;
	Node crtOperator = null;
	
	boolean isOperator(String token) {
		if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
			return true;
		}
		return false;
	}
	
	void insert(String token) {
		if (root == null) {
			root = new Node(token);
			crtOperator = root;
			return;
		}
		
		if (!isOperator(token)) {
			if (crtOperator.right == null) {
				crtOperator.right = new Node(token);
				crtOperator.right.parent = crtOperator; 
			} else {
				crtOperator.left = new Node(token);
				crtOperator.left.parent = crtOperator; 
				while (crtOperator != null && crtOperator.right != null && crtOperator.left != null)
					crtOperator = crtOperator.parent;
			}
		}
		
		if (isOperator(token)) {
			if (crtOperator.right == null) {
				crtOperator.right = new Node(token);
				crtOperator.right.parent = crtOperator;
				crtOperator = crtOperator.right;
			} else {
				crtOperator.left = new Node(token);
				crtOperator.left.parent = crtOperator;
				crtOperator = crtOperator.left;
			}
		}
	} 
	
	void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.token);
			inorder(root.right);
		}
	}
	
	int compute(Node root) {
		if (!isOperator(root.token)) { // it reaches the leaf node
			return Integer.parseInt(root.token);
		} else {
			String operator = root.token;
			if (operator.equals("+")) {
				return compute(root.left) + compute(root.right);
			}
			else if (operator.equals("-")) {
				return compute(root.left) - compute(root.right);
			}
			else if (operator.equals("*")) {
				return compute(root.left) * compute(root.right);
			}
			else {
				return compute(root.left) / compute(root.right);
			}
		}
	}
	
	public int evalRPN(String[] tokens) {
		for (int i = tokens.length - 1; i >= 0; i --) {
			this.insert(tokens[i]);
		}
		
		//inorder(this.root);
		return compute(this.root);
	}
	
	public static void main(String[] args) {
		ReversePolish solution = new ReversePolish();
		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.println(solution.evalRPN(tokens));
	}
}
