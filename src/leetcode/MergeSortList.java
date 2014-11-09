package leetcode;

public class MergeSortList {
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
}
