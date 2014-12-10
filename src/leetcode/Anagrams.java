package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Current implementation: 
 * O(n*klogk)
 * 
 * Can be improved by optimizing the hash key value.
 * 
 * @author yiluo
 *
 */
public class Anagrams {
	public List<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if (strs == null || strs.length == 0) return result;
		
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray); // O(klogk)
			String newStr = new String(charArray);
			if (map.containsKey(newStr)) {
				map.get(newStr).add(str);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(str);
				map.put(newStr, list);
			}
		}
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			if (map.get(key).size() > 1)
				result.addAll(map.get(key));
		}
		return result;
	}
}
