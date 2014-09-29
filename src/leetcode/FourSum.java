package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * O(n^3)
 *
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		Arrays.sort(num); // sort it first

		for (int i = 0; i < num.length - 3; i++) {
			if (i != 0 && num[i] == num[i - 1]) { // remove duplicate
				continue;
			}

			for (int j = i + 1; j < num.length - 2; j++) { // remove duplicate
				if (j != i + 1 && num[j] == num[j - 1])
					continue;

				int left = j + 1;
				int right = num.length - 1;
				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];
					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(num[i]);
						tmp.add(num[j]);
						tmp.add(num[left]);
						tmp.add(num[right]);
						rst.add(tmp);
						left++;
						right--;
						while (left < right && num[left] == num[left - 1]) { // remove duplicate
							left++;
						}
						while (left < right && num[right] == num[right + 1]) { // remove duplicate
							right--;
						}
					}
				}
			}
		}

		return rst;
	}
}
