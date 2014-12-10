package leetcode;

/**
 * Check out the discussion about the proof at:
 * https://oj.leetcode.com/discuss/6762/how-to-proof-the-count-is-always-less-than-10
 * 
 * 模拟
 * 
 * @author yiluo
 *
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        
        String result = "1";
        while (n > 1) {
        	result = getNext(result);
        	n --;
        }
        return result.toString();
    }
    
    private String getNext(String s) {
    	StringBuilder result = new StringBuilder();
    	int index = 0;
    	int count = 0;
    	
    	while (index < s.length()) {
    		count = 1;
	    	while (index + 1 < s.length() && s.charAt(index) == s.charAt(index + 1)){
	    		index ++;
	    		count ++;
	    	}
	    	result.append("" + count + s.charAt(index));
	    	index ++;
    	}
    	
    	return result.toString();
    }
    
    public static void main(String args[]) {
    	CountAndSay solution = new CountAndSay();
    	System.out.println(solution.countAndSay(5));
    }
}
