package interview;
/**
 * This class implements a simple routine of data type conversion from string to long.
 * 
 * @author Yi Luo
 * 
 */
public class StrToLong {
	/**
	 * 
	 * For a given string which contains characters other than digits, this method just extracts
	 * the first successive sequence of digits (with the sign) and convert this subset into a long.
	 * 
	 * Noticed limitations:
	 * 1. No exceptions thrown when encountering errors. To fix it, we can adapt the API to throw 
	 *    exceptions rather than simply print out error messages onto the console. 
	 *    
	 * 2. If errors are detected, the method still returns -1. This can be a limitation if the input
	 *    String is indeed "-1". To fix it, we can associate the result with an Exception.
	 * 
	 * 3. The last limitation I can come up with is that there is no parameters to indicate the radix
	 *    of the given String, which means the input string can only be a decimal number. We may change 
	 *    the API and add one more int argument to handle different radices.
	 *    
	 */
	public long stringToLong(String s)	{
		/* code goes here to convert a string to a long */
		long result = 0;
		long limit = -Long.MAX_VALUE;
		
		if (s != null) { // to check if the given string is null
			s = s.trim();
		} else {
			reportError(0);
			return -1;
		}
		
		if (s.length() > 0) {// to check if the given string is empty
			int length = s.length();
			boolean isNegative = false;
			int start = 0; // indicates the start of the long
			
			// 1. try to locate the first digit which should be the start of this long
			while ((start < length) && (s.charAt(start) < '0' || s.charAt(start) > '9')) {
				start ++;
			}
			
			// 2. if start exceeds the length, it means there is no legal digit
			if (start >= length) {
				reportError(1);
				return -1;
			}
			
			// 3. we need to check if it is a negative long
			if (start > 0 && s.charAt(start - 1) == '-') {
				isNegative = true;
				limit = Long.MIN_VALUE; // 2^63
			}
			
			// 4. try to locate the end of the long while building the result
			long lowerLimit = limit / 10;
			result = -(s.charAt(start) - '0');
			int end = start + 1; // indicates the end
			while (end < length && s.charAt(end) >= '0' && s.charAt(end) <= '9') {
				if (result < lowerLimit) {
					reportError(2);
					return -1;
				}
				result *= 10;
				if (result < limit + (s.charAt(end) - '0')) {
					reportError(2);
					return -1;
				}
				result -= (s.charAt(end) - '0');
				end ++;
			}
			return isNegative ? result : -result;	
			
		} else {
			reportError(0);
			return -1;
		}
	}
	
	/**
	 * This is a very simple test method provided by the problem description, which just tries one test case.
	 * In real practice, we may need more test cases. One possible idea is to read them
	 * from a file in which each line contains the original string and corresponding 
	 * correct long result.
	 * 
	 * 123	123
	 * -123	-123
	 * 78L	78
	 * 9223372036854775807l	9223372036854775807
	 * ...
	 * 
	 */
	public void test() {
		long i = stringToLong("123");
		if (i == 123) {
			// success
			System.out.println("Successed to convert the string to long.");
		}
		
		else {
			// failure
			System.out.println("Failed to convert the string to long.");
		}
		
	}
	
	/**
	 * The helper method to print error messages.
	 */
	private void reportError(int errorNum) {
		switch (errorNum) {
			case 0: System.out.println("ERROR 0: Input String is a null or empty String."); break;
			case 1: System.out.println("ERROR 1: No digit detected in the input String."); break;
			case 2: System.out.println("ERROR 2: Input String exceeds the boundary."); break;
			default: System.out.println("ERROR: Errors detected.");
		}
	}
	
	/**
	 * This is the main function where I add a few lines for my own test.
	 */
	public static void main(String args[]) {
		StrToLong question1 = new StrToLong();
		//question1.test();
		
		String testStr = "abc -9223372036854775808sf";
		System.out.println(question1.stringToLong(testStr));
	}
}
