package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstrConcatenationAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> results = new ArrayList<Integer>();
		if (S == null || L.length == 0) return results;
        
		int len = L[0].length();
		int size = S.length();
		
		if (size < len) return results;
		
		int targetNum = L.length;
		int foundNum = 0;
		
		HashMap<String, Integer> toFind = new HashMap<String, Integer>();
		HashMap<String, Integer> found = new HashMap<String, Integer>();

		for (String word : L) {
			if (!toFind.containsKey(word)) {
				toFind.put(word, 1);
			} else {
				toFind.put(word, (toFind.get(word) + 1));
			}
		}
		
		int head = 0;
		int tail = head + len - 1;
		String subStr = null;
		boolean flag = true;
		
		//for (tail = len - 1; tail < size; tail += len) {
		while (tail < size)	{
			subStr = S.substring(tail + 1 - len, tail + 1);
			if (toFind.containsKey(subStr)) { 
				if (!found.containsKey(subStr)) {
					found.put(subStr, 1);
				} else {
					found.put(subStr, (found.get(subStr) + 1));
				}
				if (found.get(subStr) <= toFind.get(subStr)) {
					foundNum ++;
				} else { // if we find more
					flag = false;
				}
			} else { // if it's not contained
				flag = false;
			}
			if (!flag) {
				found.clear();
				foundNum = 0;
				head ++;
				tail = head + len - 1;
				flag = true;
				continue;
			}
			if (foundNum == targetNum) {// we have found all words
				subStr = S.substring(head, head + len);
				while (!toFind.containsKey(subStr) // which means found does not contain subStr as well
						|| found.get(subStr) > toFind.get(subStr)) {
					if (found.containsKey(subStr)) {
						found.put(subStr, (found.get(subStr) - 1));
					}
					head += len;
					subStr = S.substring(head, head + len);
				}
				results.add(head);
			}
			tail += len;
		}
		
		return results;
    }
	
	public static void main(String args[]) {
		SubstrConcatenationAllWords solution = new SubstrConcatenationAllWords();
		String S = "abababab";
		String[] L = new String[]{"a","b", "a"};
		List<Integer> list = solution.findSubstring(S, L);
		
		for (Integer i : list) {
			System.out.print(i + ", ");
		}
	}
}
