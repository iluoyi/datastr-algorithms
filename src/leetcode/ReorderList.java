package leetcode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head != null) {
        	ListNode mid = this.findMiddle(head);
        	ListNode head2 = this.reverse(mid.next);
        	mid.next = null;
        	this.mergeList(head, head2);
        }
    }
	
    // mergeList() by Yi
	private void mergeList(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return;
		}
		ListNode prev, crt, next;
		prev = head1;
		crt = head2;
		next = prev.next;	
		while (next != null) { // when next == null, it reaches the end of a list
			prev.next = crt;
			prev = crt;
			crt = next;
			next = prev.next;
		}
		prev.next = crt;
	}
	
	private ListNode reverse(ListNode head) {
		ListNode prev, crt, next;
		prev = null;
		crt = head;
		while (crt != null) { // 4 steps
			next = crt.next;
			crt.next = prev;
			prev = crt;
			crt = next;
		}
		return prev;
	}
	
	private ListNode findMiddle(ListNode head) {
		ListNode slow, fast;
		slow = head;
		fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
