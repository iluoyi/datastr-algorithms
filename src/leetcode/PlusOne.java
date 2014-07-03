package leetcode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i --) {
        	if (digits[i] == 9) {
        		digits[i] = 0;
        	} else {
        		digits[i] ++;
        		return digits;
        	}
        }
        int[] results = new int[digits.length + 1];
        for (int i = 1; i < results.length; i ++) {
        	results[i] = digits[i - 1];
        }
        results[0] = 1;
        return results;
    }
}
