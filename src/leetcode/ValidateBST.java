package leetcode;

/**
 * O(n)
 * 
 * @author yiluo
 *
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, int low, int high) {
    	if (root == null) 
    		return true;
    	else 
    		return root.val > low && root.val < high && 
    				isValidBST(root.left, low, root.val) &&
    				isValidBST(root.right, root.val, high);
    }
}
