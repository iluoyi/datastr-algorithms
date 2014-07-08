package leetcode;

public class RemoveDupliFromSortedArrayII {
	public int removeDuplicates(int[] A) {
		int len = A.length;
		if (len <= 2) {
			return len;
		} else {
			int index = 2;
			for (int i = 2; i < len; i ++) {
				if (A[i] != A[index - 2]) {
					A[index ++] = A[i];
				}
			}
			return index;
		}
	}
}
