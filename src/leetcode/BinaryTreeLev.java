package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLev {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> level = new ArrayList<List<Integer>>();
		if (root != null) {
			
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			queue.offer(null);
			
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			
			
			TreeNode crt = null;
			while (!queue.isEmpty()) {
				crt = queue.poll();
					
				if (crt != null) {
					tempList.add(crt.val);
					if (crt.left != null) {
						queue.add(crt.left);
					}
					if (crt.right != null) {
						queue.add(crt.right);
					}
				} else { // is null
					level.add(tempList);
					tempList = new ArrayList<Integer>();
					if (!queue.isEmpty()){
						queue.add(null);
					}
				}
			}
		}
		return level;
	}
	
	public static void main (String args[]) {
		BinaryTreeLev solution = new BinaryTreeLev();
		TreeNode head = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		left.left = null;
		left.right = null;
		head.right = null;
		head.left = left;
		List<List<Integer>> level = solution.levelOrder(head);
		System.out.println(level.toString());
	}
}
