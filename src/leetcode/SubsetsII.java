package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time: O(2^n) Space: O(n)
 * 
 * @author yiluo
 * 
 */
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
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
			if (i != pos && num[i] == num[i - 1]) continue; // jump duplicates
			list.add(num[i]);
			subsetsHelper(result, list, num, i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String args[]) {
		SubsetsII solution = new SubsetsII();
		int[] sets = new int[4];
		sets[0] = 1;
		sets[1] = 0;
		sets[2] = 0;
		sets[3] = 0;
		List<List<Integer>> results = solution.subsetsWithDup(sets);
		for (List<Integer> result : results) {
			System.out.println(result);
		}
	}
}
