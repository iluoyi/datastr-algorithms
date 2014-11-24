package leetcode;

/*
 * Recursion
 * 
 * singlePath + maxPath
 * 
 */
public class BinaryTreeMaxPathSum {
	private class ResultType {
		int singlePath, maxPath;
		ResultType(int singlePath, int maxPath) {
			this.singlePath = singlePath; // the MAX single path which includes root, for the use of upper levels
			this.maxPath = maxPath; // the MAX path under this root (may or may not pass the root), cache results in lower levels
		}
	}

	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, Integer.MIN_VALUE);
		}

		ResultType left = helper(root.left);
		ResultType right = helper(root.right);

		int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
		// if singlePath < 0, it only means root.val < 0 because helper() returns only >=0 values
		singlePath = Math.max(singlePath, 0); // don't propagate negative values to upper levels

		int maxPath = Math.max(left.maxPath, right.maxPath);
		// the MAX under this root is one of:
		// 1. the MAX under this.left;
		// 2. the MAX under this.right;
		// 3. left.single + root.val + right.single.
		maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

		return new ResultType(singlePath, maxPath);
	}

	public int maxPathSum(TreeNode root) {
		ResultType result = helper(root);
		return result.maxPath;
	}
}
