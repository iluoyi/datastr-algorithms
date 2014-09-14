package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> zigzag = new ArrayList<List<Integer>>();
        if (root != null) {
        	Stack<TreeNode> crtStack = new Stack<TreeNode>();
        	Stack<TreeNode> nextStack = new Stack<TreeNode>();
        	Stack<TreeNode> tempStack = null;
        	ArrayList<Integer> result = new ArrayList<Integer>();
        	
        	crtStack.push(root);
        	TreeNode crtNode = null;
        	
        	boolean normalOrder = true; // true - left to right
        	while (!crtStack.isEmpty()) {
        		result = new ArrayList<Integer>();
	        	while (!crtStack.isEmpty()) {
	        		crtNode = crtStack.pop();
	        		result.add(crtNode.val); // visit it in stack order
	        		
	        		if (normalOrder) { // left to right
	        			if (crtNode.left != null) {
	        				nextStack.push(crtNode.left);
	        			} 
	        			if (crtNode.right != null) {
	        				nextStack.push(crtNode.right);
	        			}
	        		} else { // right to left
	        			if (crtNode.right != null) {
	        				nextStack.push(crtNode.right);
	        			}
	        			if (crtNode.left != null) {
	        				nextStack.push(crtNode.left);
	        			} 
	        		}
	        	}
	        	zigzag.add(result);
	        	tempStack = crtStack;
	        	crtStack = nextStack;
	        	nextStack = tempStack;
	        	normalOrder = !normalOrder;
        	}
        }
        return zigzag;
    }
    
    public static void main (String args[]) {
    	BinaryTreeZigzag solution = new BinaryTreeZigzag();
		TreeNode head = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		left.left = null;
		left.right = null;
		right.left = null;
		right.right = null;
		head.right = right;
		head.left = left;
		List<List<Integer>> zigzag = solution.zigzagLevelOrder(head);
		System.out.println(zigzag.toString());
	}
}
