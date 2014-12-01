package leetcode;

/**
 * first element in preorder is the root
 * 
 * @author Yi
 *
 */
public class ConstructBinaryTreeFromPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if (preorder == null || inorder == null || preorder.length != inorder.length) 
    		return null;
    	
        return myBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode myBuildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
    	if (prestart > preend || instart > inend) { //terminate conditions
    		return null;
    	} else {
    		TreeNode root = new TreeNode(preorder[prestart]); // first element as the root
    		int index = findRootIndex(inorder, preorder[prestart]);
    		int span = index - instart; // the length of the left tree
    		root.left = myBuildTree(preorder, prestart + 1, prestart + span, inorder, instart, index - 1);
    		root.right = myBuildTree(preorder, prestart + span + 1, preend, inorder, index + 1, inend);
    		return root;
    	}
    }
    
    private int findRootIndex(int[] inorder, int target) {
    	for (int i = 0; i < inorder.length; i ++) {
    		if (inorder[i] == target) {
    			return i;
    		}
    	}
    	return -1;
    }
}
