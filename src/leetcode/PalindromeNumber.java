package leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	if (x < 0) {
    		return false;
    	}
    	
        int d = 1; // divisor
        while (x / d >= 10) d *= 10;
        
        int left, right;
        while (x > 0) {
        	left = x / d;
        	right = x % 10;
        	if (left != right) {
        		return false;
        	}
        	x = x % d / 10;
        	d /= 100;
        }
        
        return true;
    }
    
    public static void main(String args[]) {
    	PalindromeNumber solution = new PalindromeNumber();
    	System.out.println(solution.isPalindrome(54435));
    }
}
