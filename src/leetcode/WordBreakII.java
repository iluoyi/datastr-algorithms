package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// f(i) = any_of(f(j) && s[j+1,i]), 0<=j<i.
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> dict) {
    	int len = s.length();
    	boolean[] f = new boolean[len + 1];
    	Arrays.fill(f, false);
    	f[0] = true; // empty string
    	
    	// we can just record WHERE to cut the string
    	// and find out result through recursion at last
    	boolean[][] prev = new boolean[len + 1][len];
    	
    	for (int i = 1; i <= len; i ++) {
    		for (int j = i - 1; j >= 0; j --) {
    			if (f[j] && dict.contains(s.substring(j, i))) {
    				f[i] = true;
    				prev[i][j] = true; // cut at j
    			}
    		}
    	}
    	
    	ArrayList<String> result = new ArrayList<String>();
    	if (f[len]) {
    		ArrayList<String> temp = new ArrayList<String>();
    		getResultViaPath(s, prev, s.length(), temp, result);
    	}
    	
    	return result;
    }
    
    // recursion
    private void getResultViaPath(String s, boolean[][] prev, 
    				int crtIndex, ArrayList<String> temp, ArrayList<String> result)	{
    	if (crtIndex == 0) { // terminate condition
    		if (temp != null && !temp.isEmpty()) {
	    		String tempResult = temp.get(temp.size() - 1);
	    		for (int i = temp.size() - 2; i >= 0; i --) {
	    			tempResult += " " + temp.get(i);
	    		}
	    		result.add(tempResult);
    		}
    	} else {
    		for (int j = 0; j < s.length(); j ++) {
    			if (prev[crtIndex][j]) {
    				temp.add(s.substring(j, crtIndex)); // f[j] + s[j, crtIndex]
    				getResultViaPath(s, prev, j, temp, result);
    				temp.remove(temp.size() - 1); // backtracking
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	WordBreakII solution = new WordBreakII();
    	Set<String> strSet = new HashSet<String>();
    	strSet.add("a");
    	List<String> result = solution.wordBreak("a", strSet);
    	System.out.println(result);
    }
}
