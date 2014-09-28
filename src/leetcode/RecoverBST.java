package leetcode;

/**
 * O(n) / O(1)
 * 
 * Mirror In-order Traversal
 * 
 * Threaded Binary Tree, traversal w/o O(n) stacks.
 * 
 * @author yiluo
 *
 */
public class RecoverBST {
	private TreeNode firstNode = null;
	private TreeNode secondNode = null;
	
	public void recoverTree(TreeNode root) {
		if (root == null) return;
		
		TreeNode prev = null, crt = root, temp = null;
		
		while (crt != null) {
			if (crt.left == null) {
				check(prev, crt);
				prev = crt;
				crt = crt.right;
			} else {
				temp = crt.left;
				
				while (temp.right != null && temp.right != crt)
					temp = temp.right; /* Find the inorder predecessor of current */ 
				
				if (temp.right == null) {
					temp.right = crt;
					crt = crt.left;
				} else {
					check(prev, crt);
					temp.right = null;
					prev = crt;
					crt = crt.right;
				}
			}
		}
		
		int tempVal = firstNode.val;
		firstNode.val = secondNode.val;
		secondNode.val = tempVal;
	}
	
	private void check(TreeNode prev, TreeNode crt) {
		if (prev != null && prev.val > crt.val) {
			if (firstNode == null) {
				firstNode = prev;
			}
			secondNode = crt;
		}
	}
	
	/**
	 * This recursive method uses O(logn) stacks during its recursions...
	 */
//	 private void traverse(TreeNode root) {
//	        if (root == null) {
//	            return;
//	        }
//	        traverse(root.left);
//	        if (firstElement == null && root.val < lastElement.val) {
//	            firstElement = lastElement;
//	        }
//	        if (firstElement != null && root.val < lastElement.val) {
//	            secondElement = root;
//	        }
//	        lastElement = root;
//	        traverse(root.right);
//	    }
}
