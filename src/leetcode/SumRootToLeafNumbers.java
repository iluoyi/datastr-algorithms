package leetcode;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int crtSum) { // dfs
    	if (root == null) {
    		return 0;
    	} 
    	
    	if (root.left == null && root.right == null) {
    		return crtSum * 10 + root.val;
    	} else {
    		return sumNumbers(root.left, crtSum * 10 + root.val) + 
    				sumNumbers(root.right, crtSum * 10 + root.val);
    	}
    }
}
