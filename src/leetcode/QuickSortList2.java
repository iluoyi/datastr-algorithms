package leetcode;

/**
 * Use 2 pointers to partition the list!
 * @author royal
 *
 */
public class QuickSortList2 {
	public ListNode sortList(ListNode head) {
		sortList(head, null);
		return head;
	}
	
	public void sortList(ListNode head, ListNode tail) {
		if (head != tail) {
			ListNode pivot = partition(head, tail);
			sortList(head, pivot);
			sortList(pivot.next, tail);
		}
    }
	
	public ListNode partition(ListNode head, ListNode tail) {
		ListNode p = head;
		ListNode q = p.next;
		
		while (q != tail) {
			if (q.val < head.val) {
				p = p.next;
				swapVal(p, q); // just swap the value here!
			}
			q = q.next;
		}
		swapVal(head, p);
		return p;
	}
	
	public void swapVal(ListNode p, ListNode q) {
		int temp = p.val;
		p.val = q.val;
		q.val = temp;
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
		
		QuickSortList2 solution = new QuickSortList2();

		ListNode newHead = solution.sortList(head);
		solution.printList(newHead);
	}
}