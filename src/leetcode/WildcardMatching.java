package leetcode;

/**
 * O(|s|*|p|)
 * 
 * String p is used to match s, so in the end we want to reach the tail of p.
 * 
 * @author yiluo
 *
 */
public class WildcardMatching { 
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) return false;
		int lenS = s.length();
		int lenP = p.length();
	    int sCur = 0;
	    int pCur= 0;
	    
	    int star = -1; // indicates the index of the newest '*'
	    int matched = 0; // indicates the latest matched index in s
	    
	    while (sCur < lenS) {
	        if (pCur < lenP && (s.charAt(sCur) == p.charAt(pCur) || p.charAt(pCur) =='?')) {
	            sCur ++;
	            pCur ++;
	        } 
	        else if (pCur < lenP && (p.charAt(pCur)  == '*')) {
	            star = pCur;
	            matched = sCur;
	            pCur ++;
	        }
	        else if (star != -1) { // p contains star
	           	pCur = star + 1;
	           	matched ++;
	           	sCur = matched;
	        }
	        else 
	            return false;
	    }
	    while (pCur < lenP && p.charAt(pCur) == '*') {
	        pCur ++;
	    }
	         
	    if (pCur == lenP)
	        return true;
	    else
	        return false;
	}
	
	public static void main(String args[]) {
//		System.out.println(new WildcardMatching().isMatch("aa", "*"));
//		System.out.println(new WildcardMatching().isMatch("aa", "****"));
//		System.out.println(new WildcardMatching().isMatch("aa", "a"));
//		System.out.println(new WildcardMatching().isMatch("aa", "aa"));
//		System.out.println(new WildcardMatching().isMatch("aaa", "aa"));
//		System.out.println(new WildcardMatching().isMatch("aa", "a*"));
//		System.out.println(new WildcardMatching().isMatch("a", "a"));
//		System.out.println(new WildcardMatching().isMatch("ab", "?*"));
//		System.out.println(new WildcardMatching().isMatch("aab", "c*a*b"));
//		System.out.println(new WildcardMatching().isMatch("", ""));
//		System.out.println(new WildcardMatching().isMatch("abcdeff", "?*"));
//		System.out.println(new WildcardMatching().isMatch("a", "ab*"));
		System.out.println(new WildcardMatching().isMatch("ab", "*a"));
	}
}
