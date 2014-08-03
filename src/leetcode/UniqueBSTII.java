package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * For i as the root, left: [start, i - 1]/right: [i + 1, end]
 * @author yiluo
 *
 */
public class UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    private ArrayList<TreeNode> generateTrees(int start, int end) {
    	ArrayList<TreeNode> rst = new ArrayList<TreeNode>(); // all possible roots
    	if (start > end) {
    		rst.add(null);
    		return rst;
    	}
    	
    	for (int i = start; i <= end; i ++) { // use i as the root
    		ArrayList<TreeNode> left = generateTrees(start, i - 1); // all possible left roots
    		ArrayList<TreeNode> right = generateTrees(i + 1, end); // all possible right roots
    		for (TreeNode l : left) {
    			for (TreeNode r : right) {
    				TreeNode root = new TreeNode(i);
    				root.left = l;
    				root.right = r;
    				rst.add(root);
    			}
    		}
    	}
    	return rst;
    }
}
