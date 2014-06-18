package leetcode;

public class Merge2SortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head, crt;
		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}

		crt = head;

		while (l1 != null || l2 != null) {
			while (l1 != null && l2 != null && l1.val <= l2.val) {
				crt.next = l1;
				crt = l1;
				l1 = l1.next;
			}
			while (l1 != null && l2 != null && l2.val <= l1.val) {
				crt.next = l2;
				crt = l2;
				l2 = l2.next;
			}
			if (l1 == null && l2 != null) {
				crt.next = l2;
				crt = l2;
				l2 = l2.next;
			}
			if (l1 != null && l2 == null) {
				crt.next = l1;
				crt = l1;
				l1 = l1.next;
			}
		}

		return head;
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
		ListNode head1 = new ListNode(1);
		ListNode crt = head1;
		int[] nodes1 = new int[] { 2, 4, 7, 8 };
		for (int i = 0; i < nodes1.length; i++) {
			ListNode newNode = new ListNode(nodes1[i]);
			crt.next = newNode;
			crt = crt.next;
		}

		ListNode head2 = new ListNode(6);
		crt = head2;
		int[] nodes2 = new int[] { 9, 20 };
		for (int i = 0; i < nodes2.length; i++) {
			ListNode newNode = new ListNode(nodes2[i]);
			crt.next = newNode;
			crt = crt.next;
		}

		Merge2SortedList solution = new Merge2SortedList();
		solution.printList(solution.mergeTwoLists(head1, head2));
	}
}
