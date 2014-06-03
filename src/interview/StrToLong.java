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
	 * This method converts a string into a long. It is able to check the sign of the result.
	 * For a given string which contains characters other than digits, this method just extracts
	 * the first successive sequence of digits and convert this subset string into a long.
	 * However, if there is NO digit, this method simply returns 0 (which is not good enough).
	 * 
	 * Noticed limitations:
	 * 1. If the input String is "abc" which contains no digits at all, there should be some ways 
	 *    to handle it. For example, the method can throw a customized BadCharacterException which
	 *    contains the information of bad characters and its first index. For now, I just return 0
	 *    when detecting no digit in the string. This is not good because sometimes users may really
	 *    attempt to convert the string "0" to a long. Then the result 0 may cause misunderstandings.  
	 *    
	 * 2. If the corresponding long of the given String actually exceeds the range of long type, it
	 * 	  causes problems. Similarly, we can throw a predefined exception for this scenario.
	 * 
	 * 3. The last limitation I can come up with is that there is no parameters to indicate the radix
	 *    of the given String, which means the input string can only be a decimal number. We may change 
	 *    the API and add one more int argument to handle different radices.
	 *    
	 */
	long stringToLong(String s)	{
		/* code goes here to convert a string to a long */
		long result = 0;
		
		if (s != null && s.length() > 0) {// to check if the given string is legal/nonempty
			int length = s.length();
			boolean isNegative = false;
			int start = 0; // indicates the start of the long int
			
			// 1. try to locate the first digit which should be the start of this long int
			while ((start < length) && (s.charAt(start) < '0' || s.charAt(start) > '9')) {
				start ++;
			}
			
			// 2. if start exceeds the length, it means there is no legal digit
			if (start >= length) {
				return 0;
			}
			
			// 3. we need to check if it is a negative long int
			if (start > 0) { 
				if (s.charAt(start - 1) == '-') {
					isNegative = true;
				}
			}
			
			// 4. try to locate the last digit which should be the end of this long int
			int end = start;
			while (end < length && s.charAt(end) >= '0' && s.charAt(end) <= '9') {
				end ++;
			}
			
			// 5. to get the real long int result
			long temp = 0;
			while (start < end) {
				temp = s.charAt(start) - '0';
				for (int i = 1; i < end - start; i ++) {
					temp *= 10;
				}
				result += temp;
				start ++;
			}
			if (isNegative) {
				result *= -1;
			}
		}
		
		return result;
	}
	
	/**
	 * This is a very simple test method which just tries one test case.
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
	void test() {
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
	 * This is the main function where I add a few lines for my own testing.
	 */
	public static void main(String args[]) {
		StrToLong question1 = new StrToLong();
		question1.test();
		
		String testStr = "-00098951215L";
		System.out.println(question1.stringToLong(testStr));
	}
}
