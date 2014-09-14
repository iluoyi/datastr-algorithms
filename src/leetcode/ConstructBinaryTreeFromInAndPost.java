package leetcode;

/**
 * last element in postorder is the root
 * 
 * @author Yi
 *
 */
public class ConstructBinaryTreeFromInAndPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if (postorder == null || inorder == null || postorder.length != inorder.length) 
    		return null;
    	
        return myBuildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode myBuildTree(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend) {
    	if (poststart > postend || instart > inend) { //terminate conditions
    		return null;
    	} else {
    		TreeNode root = new TreeNode(postorder[postend]); // first element as the root
    		int index = findRootIndex(inorder, postorder[postend]);
    		int span = inend - index; // the length of the right tree
    		root.right = myBuildTree(postorder, postend - span, postend - 1, inorder, inend - span + 1, inend);
    		root.left = myBuildTree(postorder, poststart, postend - span - 1, inorder, instart, inend - span - 1);
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
