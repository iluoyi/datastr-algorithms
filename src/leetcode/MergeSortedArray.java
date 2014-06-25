package leetcode;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int ia = m - 1, ib = n - 1, ic = m + n - 1;
		while (ia >= 0 && ib >=0) {
			A[ic--] = A[ia] >= B[ib] ? A[ia--] : B[ib--];
		}
		while (ib >=0) {
			A[ic--] = B[ib--];
		}
    }
}
