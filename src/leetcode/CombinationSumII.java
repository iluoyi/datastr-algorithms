package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DFS
 * 
 * Compared to CombinationSum I:
 * 1. i + 1 for the next recursion so that each element is not repeating;
 * 2. use prev to avoid duplicate result, for example, from [2(a), 2(b), 3, 5],
 *    we can get [2(a), 3, 5] and [2(b), 3, 5], this is redundant.
 * 
 * @author Yi
 *
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if (candidates == null) {
    		return results;
    	}
    	
    	Arrays.sort(candidates);// should sort it
    	
    	ArrayList<Integer> tempList = new ArrayList<Integer>();
    	dfs(results, tempList, target, candidates, 0); // start is important
    	
    	return results;
    }
    
    private void dfs(List<List<Integer>> results, ArrayList<Integer> tempList, int target, int[] candidates, int start) {
    	if (target == 0) {
    		results.add(new ArrayList<Integer>(tempList));
    		return;
    	} else {
    		int prev = -1;
    		for (int i = start; i < candidates.length; i ++) {
    			if (candidates[i] > target || candidates[i] == prev) continue;
    			// a different way to jump duplicates is in PermutationsII
    			tempList.add(candidates[i]);
    			dfs(results, tempList, target - candidates[i], candidates, i + 1);
    			tempList.remove(tempList.size() - 1);
    			prev = candidates[i];
    		}
    	}
    }
    
    public static void main(String args[]) {
    	CombinationSumII solution = new CombinationSumII();
    	int[] candidates = new int[]{2, 3, 6, 7};
    	List<List<Integer>> results = solution.combinationSum2(candidates, 7);
    	for (List<Integer> list : results) 
    		System.out.println(list);
    }
}
