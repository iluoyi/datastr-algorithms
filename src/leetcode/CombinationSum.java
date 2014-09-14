package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DFS
 * 
 * @author Yi
 *
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
    		for (int i = start; i < candidates.length; i ++) {
    			if (candidates[i] > target) continue;
    			
    			tempList.add(candidates[i]);
    			dfs(results, tempList, target - candidates[i], candidates, i);
    			tempList.remove(tempList.size() - 1);
    		}
    	}
    }
    
    public static void main(String args[]) {
    	CombinationSum solution = new CombinationSum();
    	int[] candidates = new int[]{2, 3, 6, 7};
    	List<List<Integer>> results = solution.combinationSum(candidates, 7);
    	for (List<Integer> list : results) 
    		System.out.println(list);
    }
}
