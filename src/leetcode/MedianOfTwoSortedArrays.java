package leetcode;

/**
 * General form: find the kth smallest value
 * 
 * I spent a lot of time working on this one!!!
 * 
 * @author yiluo
 *
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		double result1 = 0;
		double result2 = 0;
		
		if (len % 2 != 0) { // (len & 0x1) == 0, odd number
			result1 = findKth(A, 0, A.length, B, 0, B.length, len / 2 + 1);
			result2 = findKthSmallest(A, 0, A.length, B, 0, B.length, len / 2 + 1);
		} else {
			result1 = (findKth(A, 0, A.length, B, 0, B.length, len / 2 ) + findKth(A, 0, A.length, B, 0, B.length, len / 2 + 1)) * 0.5;
			result2 = (findKthSmallest(A, 0, A.length, B, 0, B.length, len / 2 ) + findKthSmallest(A, 0, A.length, B, 0, B.length, len / 2 + 1)) * 0.5;
		}
		System.out.println(result1 + ", " + result2);
		
		return result1 == result2 ? result1 : -1;
	}
	
	/**
	 * O(log(m+n)) - halve the search space
	 * 
	 * If the complexity is right, it's the best solution.
	 */
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
	
	/**
	 * O(log(m) + log(n))
	 * 
	 */
	private int findKthSmallest(int A[], int aStart, int m, int B[], int bStart, int n, int k) {
		  assert(m >= 0); assert(n >= 0); assert(k > 0); assert(k <= m+n);
		  
		  int i = (int)((double)m / (m+n) * (k-1));
		  int j = (k-1) - i;
		 
		  assert(i >= 0); assert(j >= 0); assert(i <= m); assert(j <= n);
		  // invariant: i + j = k-1
		  // Note: A[-1] = -INF and A[m] = +INF to maintain invariant
		  int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : A[aStart + i-1]);
		  int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : B[bStart + j-1]);
		  int Ai   = ((i == m) ? Integer.MAX_VALUE : A[aStart + i]);
		  int Bj   = ((j == n) ? Integer.MAX_VALUE : B[bStart + j]);
		 
		  if (Bj_1 < Ai && Ai < Bj)
		    return Ai;
		  else if (Ai_1 < Bj && Bj < Ai)
		    return Bj;
		 
		  assert((Ai > Bj && Ai_1 > Bj) || 
		         (Ai < Bj && Ai < Bj_1));
		 
		  // if none of the cases above, then it is either:
		  if (Ai < Bj)
		    // exclude Ai and below portion
		    // exclude Bj and above portion
		    return findKthSmallest(A, aStart+i+1, m-i-1, B, bStart, j, k-i-1); // j = k-(i+1), so for B, j+1..end are useless
		  else /* Bj < Ai */
		    // exclude Ai and above portion
		    // exclude Bj and below portion
		    return findKthSmallest(A, aStart, i, B, bStart+j+1, n-j-1, k-j-1);
		}
	
	public static void main(String args[]) {
		MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
		int[] A = {1, 3, 6, 8, 10};
		int[] B = {2, 7, 8, 9};
		System.out.println(solution.findMedianSortedArrays(A, B));
	}
}

