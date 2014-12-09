package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS
 * 
 * O(n^4)
 * 
 * @author yiluo
 *
 */
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		ArrayList<String> rst = new ArrayList<String>();
		String ip = "";
		helper(s, ip, 0, 0, rst);
		return rst;
	}
	
	private void helper(String s, String ip, int start, int step, ArrayList<String> rst) {
		// trim branches, if the remaining is too long
		if (s.length() - start > (4 - step) * 3) return;
		// if the remaining is too short
		if (s.length() - start < (4 - step) * 1) return;
		
		// detect a valid result
		if (s.length() == start && step == 4) {
			rst.add(ip.substring(0, ip.length() - 1)); // remove the last '.'
			return;
		}
		
		int num = 0;
		for (int i = start; i < start + 3 && i < s.length(); i ++) {
			num = num * 10 + (s.charAt(i) - '0');
			if (num <= 255) {
				helper(s, ip + num + '.', i + 1, step + 1, rst);
			}
			if (num == 0) break; // avoid 010.x.x.x, only accept 10.x.x.x
		}
	}
	
	public static void main(String args[]) {
		RestoreIPAddresses solution = new RestoreIPAddresses();
		System.out.println(solution.restoreIpAddresses("127001"));
	}
}

	