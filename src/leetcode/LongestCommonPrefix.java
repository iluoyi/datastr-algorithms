package leetcode;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		String prefix = strs[0];
		for (int index = 0; index < prefix.length(); index++) {
			for (int i = 1; i < strs.length; i++) {
				if (index >= strs[i].length() || strs[i].charAt(index) != prefix.charAt(index))
					return prefix.substring(0, index);
			}
		}

		return prefix;
	}

	public static void main(String args[]){
    	LongestCommonPrefix solution = new LongestCommonPrefix();
    	String[] strs = new String[2];
    	strs[0] = "aa";
    	strs[1] = "a";
    	System.out.println(solution.longestCommonPrefix(strs));
    }
}
