package leetcode;

public class ContainerWithMostWater {
	
	/**
	 * O(n) / O(1)
	 * 
	 * @param height
	 * @return
	 */
    public int maxArea(int[] height) {
    	if (height != null && height.length > 1) {
        int left = 0;
        int right = height.length - 1;
        
        int area, max = 0;
        while (left <= right) {
        	area = Math.min(height[left], height[right]) * (right - left);
        	max = Math.max(area, max);
        	if (height[left] <= height[right]) {
        		left ++;
        	} else {
        		right --;
        	}
        }
        
        	return max;
    	} else {
    		return 0;
    	}	
    }
}
