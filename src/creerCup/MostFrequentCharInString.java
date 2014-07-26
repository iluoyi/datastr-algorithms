package creerCup;

import java.util.BitSet;


/*
 * 
Given a string, print the character which appears the maximum number of times in the string. 
The string will contain only ascii characters. If there is a tie in the maximum number 
of times a character appears in the string, print the character which appears first in the string. 

Notes: 
1. The length of the string will be between 1 and 10000, inclusive. 
2. Make sure you don't print anything other than a single character in the function. Otherwise, your solution will be marked wrong. 
3. You only need to complete the function printMaximumOccurringCharacter. 

Sample Input #00 
helloworld 
Sample Output #00 
l 

Sample Input #01 
aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz 
Sample Output #01 
a 

Sample Input #02 
abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz 
Sample Output #02 
a 
4.
 *
 */
public class MostFrequentCharInString {
	String printMaximumOccurringCharacter(String s) {
		if (s == null || s.length() > 10000)
			return "Given string size is out of bounds";
		
		int n = 128;
		int[] countArray = new int[n];
		int[] indexArray = new int[n];
	
		for (int i = 0; i < n; i++) { 
			countArray[i] = 0;
			indexArray[i] = -1;
		}
		
		int maxCount = 0;
		char maxChar = 0, charInt;
		
		for (int i = 0; i < s.length(); i++) {
			charInt = s.charAt(i);
			countArray[charInt]++;
			if (indexArray[charInt] == -1)
				indexArray[charInt] = i;
			
			// check for maximum counts and the index
			if (countArray[charInt] > maxCount) {
				maxCount = countArray[charInt];
				maxChar = charInt;
			} else if (countArray[charInt] == maxCount) {
				if (indexArray[charInt] != -1 && indexArray[charInt] < indexArray[maxChar]) {
					maxChar = charInt;
				}
			}
		}
		System.out.println("MaxChar = " + (char) maxChar + ", index = " + indexArray[maxChar]);
		System.out.println("Count = " + countArray[maxChar]);
		
		return "Success";
	}
	
	public static void main(String args[]) {
		MostFrequentCharInString solution = new MostFrequentCharInString();
		solution.printMaximumOccurringCharacter("abbaccca");
		
//		BitSet test = new BitSet(8);
//		test.flip(2);
//		System.out.println(test.get(2));
	}
}
