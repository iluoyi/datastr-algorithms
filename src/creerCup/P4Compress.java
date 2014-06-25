package creerCup;

public class P4Compress {
	
	public static String compressStr(String str) {
		String cpStr = "";
		int counts;
		char prev, crt;
		
		prev = str.charAt(0);
		cpStr += prev;
		counts = 1;
		
		for (int i = 1; i < str.length(); i ++) {
			crt = str.charAt(i);
			if (crt == prev) {
				counts ++;
			} else {
				cpStr += (""+counts);
				counts = 1;
				cpStr += crt;
				prev = crt;
			}
		}
		cpStr += (""+counts);
		
		if (cpStr.length() > str.length()) {
			return str;
		} else {
			return cpStr;
		}
	}
	
	public static void main(String args[]) {
		String test = "aabcccccaaa";
		System.out.println(compressStr(test));
		String test1 = "aab";
		System.out.println(compressStr(test1));
	}
}
