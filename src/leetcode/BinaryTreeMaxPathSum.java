package leetcode;

public class BinaryTreeMaxPathSum {
	// store max value
	private int max;

	public int maxPathSum(TreeNode root) {
		max = (root == null) ? 0 : root.val;
		findMax(root);
		return max;
	}

	private int findMax(TreeNode node) {
		if (node == null)
			return 0;

		// recursively get sum of left and right path
		int left = Math.max(findMax(node.left), 0); // if left > 0, it contributes to the a larger sum
		int right = Math.max(findMax(node.right), 0); // if right > 0, it contributes to the a larger sum

		// update maximum here
		max = Math.max(node.val + left + right, max);

		// return sum of largest path of current node
		return node.val + Math.max(left, right); // can only select one path (back to top root)
	}
}
