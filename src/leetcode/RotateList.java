package leetcode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || n < 0) return null;
		
		ListNode crt = head;
		int len = 1;
		while (crt.next != null) {
			crt = crt.next;
			len ++;
		} // then crt will be the tail node
		
		crt.next = head; // build a ring
		
		n = n % len;
		
		// now we jump len - n steps from the head
		int k = 1;
		crt = head;
		while (k < len - n) {
			crt = crt.next; // crt points to node "len - n"
			k ++;
		}
		
		ListNode newHead = crt.next;
		crt.next = null;
		
		return newHead;
	}
}
