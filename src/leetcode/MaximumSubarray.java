package leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
        int head, tail; // two pointers 
       // int maxHead, maxTail;
        int maxSum, tempSum;
        
        maxSum = A[0];
        
        head = 0;
        tail = 0;
        tempSum = 0;
        
        while (tail < A.length) {
        	tempSum += A[tail];
        	if (tempSum > maxSum) {
        		maxSum = tempSum;
        	}
        	if (tempSum <= 0) {
        		head = tail + 1;
        		tail = head;
        		tempSum = 0;
        	} else {
        		tail ++;
        	}
        }
        
        return maxSum;
    }
	
	public static void main(String args[]) {
		MaximumSubarray solution = new MaximumSubarray();
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(solution.maxSubArray(A));
	}
}
