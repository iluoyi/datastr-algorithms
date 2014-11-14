package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> level = new LinkedList<List<Integer>>();
		if (root != null) {
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			
			TreeNode crt = null;
			int qSize = 0;
			while (!queue.isEmpty()) {
				qSize = queue.size();
				for (int i = 0; i < qSize; i ++) {
					crt = queue.poll();
					tempList.add(crt.val);
					
					if (crt.left != null) {
						queue.add(crt.left);
					}
					if (crt.right != null) {
						queue.add(crt.right);
					}
				} 
				level.addFirst(tempList);
				tempList = new ArrayList<Integer>();
			}
		}
		return level;
	}
	
	public static void main (String args[]) {
		BinaryTreeLevII solution = new BinaryTreeLevII();
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
