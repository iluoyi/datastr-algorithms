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
	 public List<List<Integer>> subsets(int[] num) {
	        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
	        if(num == null || num.length == 0) {
	            return result;
	        }
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        Arrays.sort(num);  
	        subsetsHelper(result, list, num, 0);

	        return result;
	    }


	    private void subsetsHelper(ArrayList<List<Integer>> result,
	        ArrayList<Integer> list, int[] num, int pos) {

	        result.add(new ArrayList<Integer>(list));

	        for (int i = pos; i < num.length; i++) {

	            list.add(num[i]);
	            subsetsHelper(result, list, num, i + 1);
	            list.remove(list.size() - 1);
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
