package practice;

public class RemoveVowels {
	public static String removeVowels(String testStr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < testStr.length(); i ++) {
			if (!isVowel(testStr.charAt(i))) {
				sb.append(testStr.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public static boolean isVowel(char c) {
		String vowels = "aAeEiIoOuU";
		return vowels.indexOf(c) > -1 ? true : false;
	}
	
	public static void main(String args[]) {
		System.out.println(removeVowels("yesIloveyoU"));
	}
}
