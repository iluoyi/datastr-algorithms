package leetcode;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Boolean> countMap = new HashMap<Integer, Boolean>();
        
        //init the map
        for (Integer i : num) {
        	countMap.put(i, true);
        }
        
        int max = 0;
        for (Integer i : num) {
        	if (countMap.get(i)) {
        		countMap.put(i, false);
        		int crtMax = 1;
        		int right = i.intValue() + 1;
        		while (countMap.containsKey(right)) {
        			countMap.put(right, false);
        			right ++;
        			crtMax ++;
        		}
        		int left = i.intValue() - 1;
        		while (countMap.containsKey(left)) {
        			countMap.put(left, false);
        			left --;
        			crtMax ++;
        		}
        		if (crtMax > max) {
        			max = crtMax;
        		}
        	}
        }
        
        return max;
    }
}
