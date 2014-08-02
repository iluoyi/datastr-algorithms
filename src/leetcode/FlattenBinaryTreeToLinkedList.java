package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
	// By nine_chapter
	private TreeNode lastNode = null;

    public void flatten(TreeNode root) { // recursive method
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right; // so we can record the right child
        flatten(root.left);
        flatten(right);
    }
	
	// By Yi, stupid method
//	public void flatten(TreeNode root) {
//		ArrayList<TreeNode> preOrder = preorderTraversal(root);
//		if (preOrder != null && !preOrder.isEmpty()) {
//			TreeNode prev = preOrder.get(0);
//			for (int i = 1; i < preOrder.size(); i ++) {
//				prev.right = preOrder.get(i);
//				prev.left = null;
//				prev = preOrder.get(i);
//			}
//		}
//	}
//	
//	private ArrayList<TreeNode> preorderTraversal(TreeNode root) {
//        if (root == null) {
//            return null;
//        } else {
//        	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
//            Stack<TreeNode> stack = new Stack<TreeNode>();
//            TreeNode crt = root;
//            
//            while (crt != null || !stack.isEmpty()) {
//            	result.add(crt);
//            	stack.push(crt);
//   
//            	crt = crt.left;
//            	while (crt == null && !stack.isEmpty()) {
//            		crt = stack.pop();
//            		crt = crt.right;
//            	}
//            }
//            return result;
//        }
//	}
}
