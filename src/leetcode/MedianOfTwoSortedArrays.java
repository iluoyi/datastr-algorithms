package leetcode;

/**
 * General form: find the kth value
 * O(log(m+n))
 * 
 * I spent a lot of time working on this one!!!
 * 
 * @author yiluo
 *
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		if (len % 2 != 0) { // (len & 0x1) == 0, odd number
			return findKth(A, 0, A.length, B, 0, B.length, len / 2 + 1);
		} else {
			return (findKth(A, 0, A.length, B, 0, B.length, len / 2 ) +
					findKth(A, 0, A.length, B, 0, B.length, len / 2 + 1)) * 0.5;

		}
	}
	
	private int findKth(int A[], int A_start, int A_len, int B[], int B_start, int B_len, int k) {
		if (A_len == 0) return B[B_start + k - 1]; // k - 1 is the real index
		if (B_len == 0) return A[A_start + k - 1];
		if (k == 1) return Math.min(A[A_start], B[B_start]);
		int A_sub = Math.min(k / 2, A_len);
		int B_sub = Math.min(k / 2, B_len);
		if (A[A_start + A_sub - 1] < B[B_start + B_sub - 1]) {
			return findKth(A, A_start + A_sub, A_len - A_sub, B, B_start, B_len, k - A_sub);
		} else {
			return findKth(A, A_start, A_len, B, B_start + B_sub, B_len - B_sub, k - B_sub);
		}
	}
	
	public static void main(String args[]) {
		MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
		int[] A = new int[0];
		int[] B = new int[1];
		B[0] = 1;
		System.out.println(solution.findMedianSortedArrays(A, B));
	}
}

