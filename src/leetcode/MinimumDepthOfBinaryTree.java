package leetcode;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
        return getMinDepth(root);
    }
    
    private int getMinDepth(TreeNode root) {
    	if (root == null) { // no depth value for a missing child
        	return Integer.MAX_VALUE; 
        } else {
        	if (root.left == null && root.right == null) {// if it is a leaf node
        		return 1;
        	} else {
        		return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
        	}
        }
    }
}
