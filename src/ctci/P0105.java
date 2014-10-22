package ctci;

public class P0105 {
	
	public static String compressStr(String str) {
		int counts;
		char prev, crt;
		
		StringBuilder sb = new StringBuilder();
		prev = str.charAt(0);
		counts = 1;
		
		for (int i = 1; i < str.length(); i ++) {
			crt = str.charAt(i);
			if (crt == prev) {
				counts ++;
			} else {
				sb.append(prev);
				sb.append(counts);
				counts = 1;
				prev = crt;
			}
		}
		
		String rst = sb.toString();
		if (rst.length() > str.length()) {
			return str;
		} else {
			return rst;
		}
	}
	
	public static void main(String args[]) {
		String test = "aabcccccaaa";
		System.out.println(compressStr(test));
		String test1 = "aab";
		System.out.println(compressStr(test1));
	}
}
