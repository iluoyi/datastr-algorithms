package leetcode;

public class InsertionSortList {
	
	public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return dummy.next;
    }
	
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = head;
		ListNode crt = head.next;
		ListNode p;
		
		while (crt != null) {
			p = dummy;
			while (crt.val > p.next.val && p != pre) {
				p = p.next;
			}
			
			if (p != pre) {
				pre.next = crt.next;
				crt.next = p.next;
				p.next = crt;
				crt = pre.next;
			} else {
				pre = pre.next;
				crt = pre.next;
			}
		}
		
		return dummy.next;
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
		int[] nodes = new int[]{20, 6, 7, 9, 10, 15, 5};
		for (int i = 0; i < nodes.length; i ++) {
			ListNode newNode = new ListNode(nodes[i]);
			crt.next = newNode;
			crt = crt.next;
		}
		
		InsertionSortList solution = new InsertionSortList();
		//ListNode newHead = solution.partitionList(head);
		//solution.printList(newHead);

		ListNode newHead = solution.sortList(head);
		solution.printList(newHead);
	}
}
