package leetcode;

/**
 * O(nlogn)
 * 
 * Singly linked list - consider merge sort
 * 
 * Doubly linked list - consider quick sort
 * 
 * @author yiluo
 *
 */
public class SortList {
	/**
	 * merge sort for a singly linked list
	 * 
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode middle = getMid(head);
		ListNode head2 = middle.next;
		middle.next = null; // separate the first half from the list
		
		ListNode leftHalf = sortList(head);
		ListNode rightHalf = sortList(head2);
		return mergeLists(leftHalf, rightHalf);
    }
	
	public ListNode mergeLists(ListNode left, ListNode right) {
		ListNode dummyHead = new ListNode(0);
		ListNode crt = dummyHead;
		
		while (left != null && right != null) {
			if (left.val <= right.val) {
				crt.next = left;
				left = left.next;
			} else {
				crt.next = right;
				right = right.next;
			}
			crt = crt.next;
		}
		
		crt.next = (left == null) ? right : left;
		return dummyHead.next;
	}
	
	public ListNode getMid(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode slow, fast;
		slow = head;
		fast = head;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
}
