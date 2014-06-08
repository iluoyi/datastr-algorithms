package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//  some ideas from: http://blog.csdn.net/ns_code/article/details/12977901
public class BinaryTreeIn {
	public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
        	return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> in = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>(); // empty stack
        
        TreeNode crtNode = root;
        
        while (crtNode != null || !stack.isEmpty()) {
        	if (crtNode.left != null) {
        		stack.push(crtNode);
        		crtNode = crtNode.left;
        	} else {
        		in.add(crtNode.val);
        		crtNode = crtNode.right;
        		while (crtNode == null && !stack.isEmpty()) {
        			crtNode = stack.pop(); // retrieve the mother node
        			in.add(crtNode.val);
        			crtNode = crtNode.right;
        		}
        	}
        }
        return in;
    }
	
	public static void main (String args[]) {
		BinaryTreeIn solution = new BinaryTreeIn();
		TreeNode head = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		TreeNode left = new TreeNode(3);
		left.left = null;
		left.right = null;
		right.left = left;
		right.right = null;
		head.right = right;
		head.left = null;
		List<Integer> post = solution.inorderTraversal(head);
		System.out.println(post.toString());
	}
}
