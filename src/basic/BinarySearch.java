package basic;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
	
	public static int binarySearch(ArrayList<Integer> list, int value) {
		int left = 0;
		int right = list.size() - 1;
		int mid;
		
		while (left <= right) {
			mid = (left + right) / 2;
			if (list.get(mid) > value) {
				right = mid - 1;
			} else if (list.get(mid) < value) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		
		return -1; // not found
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> testList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 7, 10, 12, 15, 20));
		System.out.println(binarySearch(testList, 20));
	}
	
}
