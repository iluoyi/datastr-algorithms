package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	 public List<List<Integer>> permute(int[] num) {
		 ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
		 if (num == null || num.length == 0) {
			 return rst;
		 }
		 permutation(rst, new ArrayList<Integer>(), num);
		 return rst;
	 }
	 
	 // helper function
	 private void permutation(ArrayList<List<Integer>> list, ArrayList<Integer> crt, int[] num) {
		 if (crt.size() == num.length) {
			 list.add(new ArrayList<Integer>(crt));// deep copy
			 return;
		 } else {
			 for (int i = 0; i < num.length; i++) {
				 if (!crt.contains(num[i])) {
					 crt.add(num[i]);
					 permutation(list, crt, num);
					 crt.remove(crt.size() - 1); // backtracking
				 }
			 }
		 }
	 }
}
