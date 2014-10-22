package leetcode;

public class FindMinInRotatedSortedArrayII {
	/**
	 * may contain duplicates!!
	 * 
	 * O(n)
	 */
	public int findMin(int[] num) {
		if(num == null || num.length == 0) {
            return -1; // should throw an exception, not sure if leetcode supports it
        }
        int l = 0;
        int r = num.length-1;
        while(l < r) {
            if(num[l] < num[r]) {
                return num[l];
            }
            int m = l + (r-l)/2;
            if(num[l] > num[m]) {
                r = m;
            } else if(num[l] < num[m]) {
                l = m+1;
            } else { // num[l] == num[m]
                if(num[l] == num[r]) {
                    l++;
                    r--;
                } else { // only the num[l] == num[m] >  num[r] case left
                    l = m+1;
                }
            }
        }
        return num[l];
	}
	
	/**
	 * Solution:
	 * For case where AL == AM == AR, the minimum could be on AM’s left or right side 
	 * (eg, [1, 1, 1, 0, 1] or [1, 0, 1, 1, 1]). In this case, we could not discard either 
	 * subarrays and therefore such worst case degenerates to the order of O(n).
	 *
	 */
	public int findMinAC(int[] A) {
		   int L = 0, R = A.length - 1;
		   while (L < R && A[L] >= A[R]) {
		      int M = (L + R) / 2;
		      if (A[M] > A[R]) {
		         L = M + 1;
		      } else if (A[M] < A[L]) {
		         R = M;
		      } else {   // A[L] == A[M] == A[R]
		         L = L + 1;
		      }
		   }
		   return A[L];
		}
	
	public static void main(String args[]) {
		FindMinInRotatedSortedArrayII solution = new FindMinInRotatedSortedArrayII();
		int[] num = {3, 3, 1};
		System.out.println(solution.findMin(num));
	}
}
