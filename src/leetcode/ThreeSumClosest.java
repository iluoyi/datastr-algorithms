package leetcode;

import java.util.Arrays;

/**
 * O(n^2)
 * 
 * @author yiluo
 *
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length == 0) return Integer.MAX_VALUE;
        
        // sort the array
        Arrays.sort(num);
        int left, right; // jia bi
        int sum, result = Integer.MAX_VALUE;
        int minGap = Integer.MAX_VALUE, tempGap = 0;
        
        for (int i = 0; i < num.length - 2; i ++) {
        	left = i + 1;
        	right = num.length - 1;
        	while (left < right) { // three elements
        		sum = num[i] + num[left] + num[right];
        		if (sum == target) return sum;
        		else if (sum < target) {
        			left ++;
        		} else {
        			right --;
        		}
        		tempGap = Math.abs(sum - target);
        		if (tempGap < minGap) {
        			minGap = tempGap;
        			result = sum;
        		}
        	}
        }
        return result;
    }
}
