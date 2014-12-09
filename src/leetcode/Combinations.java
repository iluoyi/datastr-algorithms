package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		ArrayList<Integer> comb = new ArrayList<Integer>();

		if (n >= k) {
			getCombinations(combinations, comb, n, k, 1);
		}
		return combinations;
	}

	private void getCombinations(List<List<Integer>> combinations,
			List<Integer> comb, int n, int k, int crt) {
		if (comb.size() == k) {
			combinations.add(new ArrayList<Integer>(comb)); // deep copy
		} else {
			for (int i = crt; i <= n + i - k; i++) {
				comb.add(i);
				getCombinations(combinations, comb, n, k, i + 1);
				comb.remove(comb.size() - 1); // backtracing
			}
		}
	}
}
