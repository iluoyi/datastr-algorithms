package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevI {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) {
			return new Stack<List<Integer>>();
		}
		
		LinkedList<List<Integer>> levelResult = new LinkedList<List<Integer>>();
		List<Integer> crtList = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.offer(root);
		queue.offer(null);
		
		TreeNode crt = null;
		while (!queue.isEmpty()) {
			crt = queue.poll();
			
			if (crt == null) {
				if (crtList.isEmpty()) {
					break;
				}
				levelResult.addFirst(crtList);
				crtList = new ArrayList<Integer>();
				queue.offer(null);
			} else {
				crtList.add(crt.val);
				if (crt.left != null) {
					queue.offer(crt.left);
				}
				if (crt.right != null) {
					queue.offer(crt.right);
				}
			}
		}
		
		return levelResult;
    }
	
	public static void main (String args[]) {
		BinaryTreeLevI solution = new BinaryTreeLevI();
		TreeNode head = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		left.left = null;
		left.right = null;
		head.right = null;
		head.left = left;
		List<List<Integer>> level = solution.levelOrderBottom(head);
		System.out.println(level.toString());
	}
}
