package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time: O(2^n)
 * Space: O(n)
 * 
 * @author yiluo
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] s) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if (s != null && s.length != 0) {
			Arrays.sort(s);
			ArrayList<Integer> path = new ArrayList<Integer>();
			subsetsHelper(s, 0, path, result);
		}
		
		return result;
	}
	
	private void subsetsHelper(int[] S, int step, ArrayList<Integer> path, ArrayList<List<Integer>> result) {
		if (step == S.length) {
			// should be deep copy here!
			result.add(new ArrayList<Integer>(path));
		} else {
			// don't add the current one
			subsetsHelper(S, step + 1, path, result);
			
			// add the current one
			path.add(S[step]);
			subsetsHelper(S, step + 1, path, result);
			path.remove(path.size() - 1);
		}
	}
	
	public static void main(String args[]) {
		Subsets solution = new Subsets();
		int[] sets = new int[1];
		sets[0] = 0;
		List<List<Integer>> results = solution.subsets(sets);
		for (List<Integer> result : results) {
			System.out.println(result);
		}
	}
}
