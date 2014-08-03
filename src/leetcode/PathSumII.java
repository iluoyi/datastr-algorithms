package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) { // sum might be negative!
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
    	if (root != null) {
    		path.add(root.val);
    		pathSumHelper(root, sum - root.val, path, results);
    	}
    	return results;
    }
    
    private void pathSumHelper(TreeNode crt, int delta,
    							ArrayList<Integer> path, ArrayList<List<Integer>> results) {
    	if (crt != null) { // cannot branch-bound cut since sum can be <0
	    	if (crt.left == null && crt.right == null && delta == 0) { // leaf node
	    		results.add(new ArrayList<Integer>(path));
	    	} else {
	    		if (crt.left != null) {
	    			path.add(crt.left.val);
	    			pathSumHelper(crt.left, delta - crt.left.val, path, results);
	    			path.remove(path.size() - 1);
	    		}
	    		if (crt.right != null) {
	    			path.add(crt.right.val);
	    			pathSumHelper(crt.right, delta - crt.right.val, path, results);
	    			path.remove(path.size() - 1);
	    		}
	    	}
    	}
    }
    
    public static void main(String args[]) {
    	PathSumII solution = new PathSumII();
    	TreeNode root = new TreeNode(-2);
    	root.left = null;
    	root.right = new TreeNode(-3);
    	List<List<Integer>> result = solution.pathSum(root, -5);
    	
    	for (List<Integer> list : result) {
    		System.out.println(list);
    	}
    }
}
