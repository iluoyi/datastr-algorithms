package leetcode;

public class MergeSortList {
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
	
	public void printList(ListNode head) {
		ListNode crt = head;
		while (crt != null) {
			System.out.print(crt.val + ", ");
			crt = crt.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		ListNode head = new ListNode(8);
		ListNode crt = head;
		int[] nodes = new int[]{3, 6, 7, 9, 10, 15, 5};
		for (int i = 0; i < nodes.length; i ++) {
			ListNode newNode = new ListNode(nodes[i]);
			crt.next = newNode;
			crt = crt.next;
		}
		
		MergeSortList solution = new MergeSortList();
		
		//ListNode newHead = solution.partitionList(head);
		//solution.printList(newHead);

		ListNode newHead = solution.sortList(head);
		solution.printList(newHead);
	}
}
