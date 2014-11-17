package leetcode;

import java.util.Stack;

/**
 * O(n)
 * 
 * @author yiluo
 *
 */
public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) return 0;
		
		Stack<Integer> index = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i <= height.length; i ++) {
			int crt = (i == height.length) ? -1 : height[i]; // set the last element -1
			while (!index.isEmpty() && crt <= height[index.peek()]) {
				int h = height[index.pop()];
				int w = index.isEmpty() ? i : i - index.peek() - 1;
				max = Math.max(max, h * w);
			}
			index.push(i);
		}
		
		return max;
	}
}
