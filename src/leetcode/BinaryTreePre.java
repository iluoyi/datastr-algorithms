package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePre {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        } else {
        	ArrayList<Integer> result = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode crt = root;
            
            while (crt != null || !stack.isEmpty()) {
            	result.add(crt.val);
            	stack.push(crt);
            	crt = crt.left;
            	while (crt == null && !stack.isEmpty()) {
            		crt = stack.pop();
            		crt = crt.right;
            	}
            }
            return result;
        }
	}
	
	public static void main (String args[]) {
		BinaryTreePre solution = new BinaryTreePre();
		TreeNode head = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		left.left = null;
		left.right = null;
		head.right = null;
		head.left = left;
		ArrayList<Integer> post = solution.preorderTraversal(head);
		System.out.println(post.toString());
	}
}
