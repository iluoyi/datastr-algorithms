package leetcode;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head, slow1 = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow1 = slow1.next;
			if (fast == slow1) { // meetup
				ListNode slow2 = head;
				while (slow1 != slow2) {
					slow2 = slow2.next;
					slow1 = slow1.next;
				}
				return slow2;
			}
		}
		return null;
	}
}
