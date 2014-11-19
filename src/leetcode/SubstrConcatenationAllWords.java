package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstrConcatenationAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> results = new ArrayList<Integer>();
		if (S == null || L.length == 0) return results;
        
		int len = L[0].length();
		int sSize = S.length();
		int lSize = L.length;
		
		if (sSize < len) return results;
		
		HashMap<String, Integer> toFind = new HashMap<String, Integer>();
		HashMap<String, Integer> found = new HashMap<String, Integer>();

		for (String word : L) {
			if (!toFind.containsKey(word)) {
				toFind.put(word, 1);
			} else {
				toFind.put(word, (toFind.get(word) + 1));
			}
		}

		/**
		 * n = sSize
		 * m = lSize
		 * O((n - len*m)*m) / O(m)
		 * 
		 * Naive
		 */
//		for (int i = 0; i <= S.length() - len * lSize; i ++){
//            found.clear();
//            int j;
//            for (j = 0; j < lSize; j ++){
//                int k = i + j * len;
//                String stub = S.substring(k, k + len);
//                if (!toFind.containsKey(stub)) break;
//                if(!found.containsKey(stub)){
//                    found.put(stub, 1);
//                }
//                else{
//                    found.put(stub, found.get(stub) + 1);
//                }
//                if (found.get(stub) > toFind.get(stub)) break;
//            }
//            if (j == lSize) results.add(i);
//        }
//        return results;
        
        /**
         * 	n = sSize
		 * 	m = lSize
		 * 
         *	1. If it is not a valid word in list L, restart from next substring (i.e. begin += k);
         *	2. If it is a valid word but has seen before (i.e. a duplicate), forward begin pointer until previous one is removed from the current window;
         *	3. Otherwise, add the substring to the current collection. If we get all words (i.e. hit a concatenation), forward begin pointer by one and check the next substring.
         *
         * 	O(2 * n/len * len) = O(n) / O(m * len)
         * 
         */
		int head, crt, foundNum;
				
        for (int i = 0; i < len; i++) {  // for each char within [0..len]
        	found.clear();
        	foundNum = 0;
        	head = i;
        	crt = head;
        	
			while (crt <= sSize - len) {
				String subStr = S.substring(crt, crt + len);
				if (toFind.containsKey(subStr)) { // if found
					foundNum++;
					if (found.containsKey(subStr)) {
						found.put(subStr, found.get(subStr) + 1);
					} else {
						found.put(subStr, 1);
					}

					while (found.get(subStr) > toFind.get(subStr)) { // exceeds the given number
						String temp = S.substring(head, head + len);
						if (found.containsKey(temp)) {
							found.put(temp, found.get(temp) - 1);
							foundNum--;
						}
						head += len;
					}
					
					if (foundNum == lSize) { // if we get all words
						results.add(head);
						String temp = S.substring(head, head + len);
						if (found.containsKey(temp)) {
							found.put(temp, found.get(temp) - 1);
							foundNum--;
						}
						head += len;
					} 
					
					crt += len;
				} else { // if invalid
					head = crt + len;
					crt = head;
					foundNum = 0;
					found.clear();
				}
			}
         }  
        
		return results;
    }
	
	public static void main(String args[]) {
		SubstrConcatenationAllWords solution = new SubstrConcatenationAllWords();
		String S = "abaababbaba";
		String[] L = new String[]{"ab","ba","ab","ba"};
		List<Integer> list = solution.findSubstring(S, L);
		
		for (Integer i : list) {
			System.out.print(i + ", ");
		}
	}
}
