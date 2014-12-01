package leetcode;


public class FlattenBinaryTreeToLinkedList {

	// recursive
	private TreeNode lastNode = null; // java use global varible to simulate pointers
    public void flatten(TreeNode root) { // recursive method - preorder
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
    
    //  simple and elegent - non-recursive 
	public void flatten1(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				TreeNode pre = root.left;
				while (pre.right != null) {
					pre = pre.right;
				}
				pre.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
	
}
