package leetcode;

/**
 * Should process the linked list in one run
 * 
 * 1. find pre of m; (1 <= m <= length)
 * 2. reverse nodes till n; (m <= n <= length)
 * 3. concatenate 3 parts: pre, crt, post
 * 
 * @author yiluo
 *
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (head == null) return null;
    	
    	ListNode endOfPre, tempHead, tempEnd, headOfPost, pre, crt, next, newHead;
    	
    	int k = 1;
    	if (m > 1) {
	    	endOfPre = head;
	    	while (k < m - 1) {
	    		endOfPre = endOfPre.next;
	    		k ++;
	    	}
	    	tempEnd = endOfPre.next;
    	} else { // m == 1
    		endOfPre = null;
    		tempEnd = head;
    	}
    	
    	// 2. reverse m to n
    	k = m;
    	pre = tempEnd;
    	crt = pre.next; // might be null
    	pre.next = null;
    	
    	// 0 <= n - m <= 2
    	if (n - k == 0) {
    		tempHead = pre;
    		headOfPost = crt;
    	} else if (n - k == 1) {
    		headOfPost = crt.next; // might be null
    		crt.next = pre;
    		tempHead = crt;
    	} else {
	    	next = crt.next;	
	    	while (k <= n - 2) {
	    		crt.next = pre;
	    		pre = crt;
	    		crt = next;
	    		next = next.next;
	    		k++;
	    	}
	    	headOfPost = crt.next; // might be null
    		crt.next = pre;
    		tempHead = crt;
    	}
    	
    	// 3. concatenate 3 parts
    	if (endOfPre != null) {
    		endOfPre.next = tempHead;
    		newHead = head;
    	} else {
    		newHead = tempHead;
    	}
    	tempEnd.next = headOfPost;
    	
    	return newHead;
    }
    
    public static void main(String args[]) {
		int[] testInput = {1, 2, 3, 4, 5, 6, 7, 8};
		ListNode head = new ListNode(testInput[0]);
		ListNode crt = head;
		
		for (int i = 1; i < testInput.length; i ++) {
			crt.next = new ListNode(testInput[i]);
			crt = crt.next;
		}
		
		ReverseLinkedListII solution = new ReverseLinkedListII();
		head = solution.reverseBetween(head, 1, 3);
		
		crt = head;
		while (crt != null) {
			System.out.print(crt.val + ", ");
			crt = crt.next;
		}
	}
}
