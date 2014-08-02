package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// f(i) = any_of(f(j) && s[j+1,i]), 0<=j<i.
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
    	int len = s.length();
    	boolean[] f = new boolean[len + 1];
    	Arrays.fill(f, false);
    	f[0] = true; // empty string
    	
    	for (int i = 1; i <= len; i ++) {
    		for (int j = i - 1; j >= 0; j --) {
    			if (f[j] && dict.contains(s.substring(j, i))) {
    				f[i] = true;
    				break;
    			}
    		}
    	}
    	
    	return f[len];
    }
    
    public static void main(String[] args) {
    	WordBreak solution = new WordBreak();
    	Set<String> strSet = new HashSet<String>();
    	strSet.add("aaaaaaaaaa");
    	strSet.add("aaaaaaaaa");
    	strSet.add("aaaaaaaa");
    	strSet.add("aaaaaaa");
    	strSet.add("aaaaaa");
    	strSet.add("aaaaa");
    	strSet.add("aaaa");
    	strSet.add("aaa");
    	strSet.add("aa");
    	strSet.add("a");
    	System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", strSet));
    }
}
