package leetcode;

public class ConvertedSortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num, 0, num.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] num, int left, int right) {
		int len = right - left + 1;
		if (len <= 0)
			return null;

		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, left, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, right);

		return root;
	}
}
