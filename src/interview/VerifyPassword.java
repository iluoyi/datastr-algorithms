package interview;

/**
 * By Epic OA
 * 
 * @author Yi
 *
 */
public class VerifyPassword {
/*
 * Verify if the given password is valid/invalid
 *  1. must be 5-12 characters long 
 *	2. must contain at least one number and one lowercase character 
 *  3. a sequence must not be followed by the same sequence (like 123123qs isinvalid, 123qs123 is valid)
 */
	public static boolean isValidPwd(String str) {
		if (str == null || str.length() < 5 || str.length() > 10) 
			return false;
		
		int len = str.length();
		boolean hasNum = false, hasLow = false;
		for (int i = 0; i < len; i ++) {
			if (Character.isDigit(str.charAt(i)))
				hasNum = true;
			if (Character.isLowerCase(str.charAt(i)))
				hasLow = true;
		}
		if (!hasNum || !hasLow) return false;
		
		for (int i = 0; i < len - 1; i ++) {
			for (int j = i + 1; j < len; j ++) {
				if (str.charAt(i) == str.charAt(j)) {
					if (j + j - i <= len && str.substring(i, j).equals(str.substring(j, j + (j - i))))
						return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		System.out.println(isValidPwd("123123qs"));
	}
}
