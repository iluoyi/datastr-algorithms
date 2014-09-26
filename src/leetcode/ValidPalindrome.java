package leetcode;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        
        s = s.trim();
        if (s.isEmpty()) return true; // if s is empty
        
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
        	while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) i ++;
        	if (i >= s.length()) return true; // if all non-alphanumerics, return true 
        	while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) j --;
        	if (j < 0) return true;
        	if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
        		i ++;
        		j --;
        	} else {
        		return false;
        	}
        }
        
        return true;
    }
    
    public static void main(String args[]) {
    	ValidPalindrome solution = new ValidPalindrome();
    	System.out.println(solution.isPalindrome(".,"));
    }
}
