package leetcode;

/**
 * There is another DP implementation which we can consider later
 * 
 * @author yiluo
 *
 */
public class RegularExpressionMatching {
	/**
	 * Recursive algorithm
	 * 
	 */
	public boolean isMatch(String s, String p) {
        if (s == null || p == null)
        	return true;
 
        if (p.length() == 0)
            return s.length() == 0;
 
        if (p.length() == 1) { // if p's length == 1
            if (s.length() == 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
                return true;
            } else {
                return false;
            }
        }
        
        if (p.charAt(1) != '*') { // if p.length() > 1 && p[1] != '*'
            if (s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
                return isMatch(s.substring(1), p.substring(1)); // recursive call
            } else {
            	return false;
            }
        } else { // if p.length() > 1 && p[1] == '*'
            while (s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) { // until [1] doesn't match
                if (isMatch(s, p.substring(2)))
                    return true;
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }
 
    public static void main(String[] args) {
//		System.out.println(new RegularExpressionMatching().isMatch("aa", "a"));
//		System.out.println(new RegularExpressionMatching().isMatch("aa", "aa"));
//		System.out.println(new RegularExpressionMatching().isMatch("aaa", "aa"));
//		System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
//		System.out.println(new RegularExpressionMatching().isMatch("a", "a"));
//		System.out.println(new RegularExpressionMatching().isMatch("ab", ".*"));
//		System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b"));
//		System.out.println(new RegularExpressionMatching().isMatch("", ""));
//		System.out.println(new RegularExpressionMatching().isMatch("abcdeff", ".*"));
		System.out.println(new RegularExpressionMatching().isMatch("a", "ab*"));
//		System.out.println(new RegularExpressionMatching().isMatch("bb", ".bab"));
    }
}
