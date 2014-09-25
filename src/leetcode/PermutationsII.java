package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// may contain duplicates, return unique permutations
// 1. sort
// 2. 判断前面的一个数是否和自己相等，相等的时候则前面的数必须使用了，自己才能使用
public class PermutationsII {
	 public List<List<Integer>> permuteUnique(int[] num) {
		 ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
		 if (num == null || num.length == 0) {
			 return rst;
		 }
		 Arrays.sort(num);
		 int[] visited = new int[num.length];
		 permutation(rst, new ArrayList<Integer>(), num, visited);
		 return rst;
	 }
	 
	 // helper function
	 private void permutation(ArrayList<List<Integer>> list, ArrayList<Integer> crt, int[] num, int[] visited) {
		 if (crt.size() == num.length) {
			 list.add(new ArrayList<Integer>(crt));// deep copy
			 return;
		 } else {
			 for (int i = 0; i < num.length; i++) {
				 if (visited[i] == 0) { // not visited
					 if (i != 0 && visited[i - 1] == 0 && num[i] == num[i - 1]) continue; // if pre duplicate not used
					 
					 visited[i] = 1;
					 crt.add(num[i]);
					 permutation(list, crt, num, visited);
					 crt.remove(crt.size() - 1); // backtracking
					 visited[i] = 0;
				 }
			 }
		 }
	 }
}
