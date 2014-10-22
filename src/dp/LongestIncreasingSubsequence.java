package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

	/**
	 * best[i] = max(best[j] + 1), j < i && num[j] <= num[i];
	 * best[0] = 1;
	 * 
	 * O(n^2) / O(n)
	 * 
	 * @param num
	 * @return
	 */
	public ArrayList<Integer> getLIS(int[] num) {
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if (num != null && num.length > 0) {
			int len = num.length;
			int[] best = new int[len];
			best[0] = 1;
			
			int[] preIndex = new int[len];
			Arrays.fill(preIndex, -1);
			
			for (int i = 1; i < len; i ++) {
				for (int j = 0; j < i; j ++) {
					if (num[j] < num[i]) {
						if (best[j] + 1 > best[i]) {
							best[i] = best[j] + 1;
							preIndex[i] = j;
						}
					}
				}
			}
			
			int bestLen = 0;
			int endIndex = 0;
			for (int i = 0; i < len; i ++) {
				if (best[i] > bestLen) {
					bestLen = best[i];
					endIndex = i;
				}	
			}
			
			while (endIndex != -1) {
				rst.add(0, num[endIndex]);
				endIndex = preIndex[endIndex];
			}
		}
		return rst;
	}
	
	public static void main(String args[]) {
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		int[] num = {1,9,3,8,11,4,5,6,4,1,9,7,1,7};
		System.out.println(solution.getLIS(num));
	}
}
