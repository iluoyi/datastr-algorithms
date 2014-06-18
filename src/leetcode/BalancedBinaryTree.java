package leetcode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		return balancedHeight(root) >= 0;
	}
	
	private int balancedHeight(TreeNode root) {
		if (root == null) return 0;
		
		int left = balancedHeight(root.left);
		int right = balancedHeight(root.right);
		
		if (left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;
		
		return Math.max(left, right) + 1;
	}
}
