package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePre {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            //HashSet<TreeNode> expanded = new HashSet<TreeNode>();
            ArrayList<Integer> pre = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            
            while (!stack.isEmpty()) {
                TreeNode crtNode = stack.pop();
                if (crtNode.right != null) {
                    stack.push(crtNode.right);
                }
                if (crtNode.left != null) {
                    stack.push(crtNode.left);
                } 
                pre.add(crtNode.val);
            }
            return pre;
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
