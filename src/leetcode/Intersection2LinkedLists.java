package leetcode;

public class Intersection2LinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		
		int lenA = getLen(headA);
		int lenB = getLen(headB);
		
		if (lenA > lenB) {
			while (lenA > lenB) {
				headA = headA.next;
				lenA --;
			}
		} else {
			while (lenA < lenB) {
				headB = headB.next;
				lenB --;
			}
		}
		
		while (headA != null) {
			if (headA == headB) {
				return headA;
			} else {
				headA = headA.next;
				headB = headB.next; 
			}
		}
		
		return null;
	}
	
	public int getLen(ListNode head) {
		ListNode crt = head;
		int len = 0;
		while (crt != null) {
			crt = crt.next;
			len ++;
		}
		
		return len;
	}
}
 