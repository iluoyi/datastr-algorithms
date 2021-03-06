package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePost {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        } else {
        	// some ideas from: http://blog.csdn.net/ns_code/article/details/12977901
        	ArrayList<Integer> result = new ArrayList<Integer>();
        	Stack<TreeNode> stack = new Stack<TreeNode>();
        	stack.push(root);
        	TreeNode crtNode, preNode = null;
        	
        	while (!stack.isEmpty()) {
        		crtNode = stack.peek();
        		if (crtNode.right == null && crtNode.left == null || 
        				preNode != null && (crtNode.left == preNode || crtNode.right == preNode)) {
        			crtNode = stack.pop();
        			result.add(crtNode.val);
        			preNode = crtNode;
        		} else {
	        		if (crtNode.right != null) {
	        			stack.push(crtNode.right);
	        		}
	        		if (crtNode.left != null) {
	        			stack.push(crtNode.left);
	        		}
        		}
        	}
        	
        	return result;
        	// Yi's implementation
//            HashSet<TreeNode> expanded = new HashSet<TreeNode>();
//            ArrayList<Integer> post = new ArrayList<Integer>();
//            Stack<TreeNode> stack = new Stack<TreeNode>();
//            stack.push(root);
//            
//            while (!stack.isEmpty()) {
//                TreeNode crtNode = stack.peek();
//                if (!expanded.contains(crtNode) && crtNode.right != null) {
//                    stack.push(crtNode.right);
//                }
//                if (!expanded.contains(crtNode) && crtNode.left != null) {
//                    stack.push(crtNode.left);
//                } 
//                if (crtNode.right == null && crtNode.left == null || expanded.contains(crtNode)) {
//                    crtNode = stack.pop();
//                    post.add(crtNode.val);
//                }
//                expanded.add(crtNode);
//            }
//            return post;
        }
    }
	
	public static void main (String args[]) {
		BinaryTreePost solution = new BinaryTreePost();
		TreeNode head = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		left.left = null;
		left.right = null;
		head.right = null;
		head.left = left;
		ArrayList<Integer> post = solution.postorderTraversal(head);
		System.out.println(post.toString());
	}
}
