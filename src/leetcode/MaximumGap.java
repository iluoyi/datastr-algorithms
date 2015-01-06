package leetcode;

import java.util.Arrays;

public class MaximumGap {
	public int maximumGap(int[] num) {
		if (num != null && num.length > 1) {
			int max = num[0], min = num[0], len = num.length;
			for (int i = 1; i < len; i ++) {
				max = Math.max(max, num[i]);
				min = Math.min(min, num[i]);
			}
			int bucketRange = (int) Math.ceil((double) (max - min) / (len - 1)); // at least
			int bucketSize = (max - min) / bucketRange + 1; // at most
			
			int[] bucketMin = new int[bucketSize];
			int[] bucketMax = new int[bucketSize];
			Arrays.fill(bucketMax, Integer.MIN_VALUE);
			Arrays.fill(bucketMin, Integer.MAX_VALUE);
		
			for (int i = 0; i < len; i ++) { // distribute each element
				int index = (num[i] - min) / bucketRange;
				bucketMax[index] = Math.max(num[i], bucketMax[index]);
				bucketMin[index] = Math.min(num[i], bucketMin[index]);
			}
			
			int maxGap = 0, prev = 0, next = 0;
			
			while (prev < bucketSize) {
				if (bucketMax[prev] == Integer.MIN_VALUE) {
					prev ++;
					continue;
				} else {
					next = prev + 1;
					while (next < bucketSize && bucketMax[next] == Integer.MIN_VALUE) {
						next ++;
					}
					if (next < bucketSize)
						maxGap = Math.max(maxGap, bucketMin[next] - bucketMax[prev]);
					prev = next;
				}
			}
			
			return maxGap;
		} else {
			return 0;
		}
	}
	
	public static void main(String args[]) {
		MaximumGap solution = new MaximumGap();
		int[] input = {3, 8, 3, 2, 4};
		System.out.println(solution.maximumGap(input));
	}
}
