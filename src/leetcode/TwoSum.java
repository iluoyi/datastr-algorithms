package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		
		ArrayList<Integer> indexList = null;
		for (int i = 0; i < numbers.length; i ++) {
			if (map.containsKey(numbers[i])) {
				indexList = map.get(numbers[i]);
				indexList.add(i);
			} else {
				indexList = new ArrayList<Integer>();
				indexList.add(i);
				map.put(numbers[i], indexList);
			}
		}
		
		int[] index = new int[2];
		int diff = 0;
		for (int i = 0; i < numbers.length; i ++) {
			diff = target - numbers[i];
			if (map.containsKey(diff)) {
				indexList = map.get(diff);
				for (Integer k : indexList) {
					if (k != i) { // exactly one solution
						index[0] = i + 1;
						index[1] = k + 1;
						return index;
					}
				}
			}
		}
		
		return index;
	}
	
	public static void main(String args[]) {
		TwoSum solution = new TwoSum();
		int[] num = {0, 4, 3, 0};
		int[] results = solution.twoSum(num, 0);
		for (int i = 0; i < results.length; i ++) {
			System.out.print(results[i] + ", ");
		}
	}
}
