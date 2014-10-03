package leetcode;

import java.util.LinkedList;

/**
 * Use a stack
 * 
 * O(n) / O(n)
 * 
 * @author yiluo
 *
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "";
		}
		LinkedList<String> stack = new LinkedList<String>(); // maintain a stack
		StringBuilder res = new StringBuilder();
		int i = 0;

		while (i < path.length()) {
			int index = i;
			StringBuilder temp = new StringBuilder();
			while (i < path.length() && path.charAt(i) != '/') {
				temp.append(path.charAt(i));
				i++;
			}
			if (index != i) { // until we encounter a slash '/'
				String str = temp.toString();
				if (str.equals("..")) {
					if (!stack.isEmpty())
						stack.pop();
				} else if (!str.equals(".")) {
					stack.push(str);
				}
			}
			i++;
		}
		
		while (!stack.isEmpty()) {
			res.insert(0, "/" + stack.pop());
		}
		
		if (res.length() == 0)
			return "/";
		
		return res.toString();
	}
	
	public static void main(String args[]) {
		SimplifyPath solution = new SimplifyPath();
		System.out.println(solution.simplifyPath("/a/./b/../../c/"));
	}
}
