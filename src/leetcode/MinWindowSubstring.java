package leetcode;

public class MinWindowSubstring {
	public String minWindow(String S, String T) {
		if (S == null || T == null) return "";
		if (S.length() < T.length()) return "";
		
        int charNum = 256;
        
        int minWidth = Integer.MAX_VALUE;
        int minStart = 0;
        
        int foundCharNum = 0;
        int tail = 0;
        int head = 0;
        
     // use ascii and array to index chars and record the counts
        int[] needToFind = new int[charNum];
        int[] hasFound = new int[charNum];

        for (int i = 0; i < charNum; i ++) {
        	needToFind[i] = 0;
        	hasFound[i] = 0;
        }
        
        for (int i = 0; i < T.length(); i ++) {
        	needToFind[T.charAt(i)] ++;
        }
        
        for (tail = 0; tail < S.length(); tail ++) {
        	// if we detect a new char which is a part of T
        	if (needToFind[S.charAt(tail)] > 0) {
        		hasFound[S.charAt(tail)] ++;
        		if (hasFound[S.charAt(tail)] <= needToFind[S.charAt(tail)]) {
        			foundCharNum ++;
        		}
        	}
        	
        	// if we find a valid number of chars (a window) for T, we then check the width
        	if (foundCharNum == T.length()) {
        		while (hasFound[S.charAt(head)] > needToFind[S.charAt(head)] ||
        		                needToFind[S.charAt(head)] == 0) {
        		    hasFound[S.charAt(head)] --;
        			head ++; // move the head pointer to tail direction
        		}
        		if (minWidth > (tail - head + 1)) {
        			minWidth = tail - head + 1;
        			minStart = head;
        		}
        	}
        }
        if (minWidth < Integer.MAX_VALUE)
        	return S.substring(minStart, minStart + minWidth);
        else 
        	return "";
    }
}
