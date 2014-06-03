package leetcode;


public class QuickSortList {

	public ListNode sortList(ListNode head) {
		if (head != null) {
			ListNode tail = head;
			while (tail.next != null) {
				tail = tail.next;
			}
			
			ListNode[] result = sortList(head, tail);
			return result[0];
		} else {
			return head;
		}
    }
	
	public ListNode[] sortList(ListNode head, ListNode tail) {		
		ListNode[] nodes = new ListNode[2];
		nodes[0] = head;
		nodes[1] = tail;
		
		if (tail == null) {
			nodes[1] = head;
			return nodes;
		}
		
		if (head == null) {
			nodes[0] = tail;
			return nodes;
		}
		
		if (head != tail) {
			ListNode[] result = partitionList(head, tail);//a, p, b
			ListNode a = result[0];
			ListNode p1 = result[1];
			ListNode p = result[2];
			ListNode p2 = result[3];
			ListNode b = result[4];
			
			ListNode[] left = sortList(a, p1);
			ListNode[] right = sortList(p2, b);
			
			left[1].next = p;
			p.next = right[0];
			right[1].next = null;
			
			nodes[0] = left[0];
			nodes[1] = right[1];
		}
		
		return nodes;
	}
	
	
	public ListNode[] partitionList(ListNode head, ListNode tail) {
		ListNode[] result = new ListNode[5];
		ListNode pivot = head;
		ListNode a = pivot;
		ListNode b = pivot;
		ListNode crt = pivot.next;
		ListNode next = crt.next;
		ListNode p1;
		ListNode flagNode = tail.next;
		
		while (crt != flagNode) {
			if (crt.val < pivot.val) {
				crt.next = a;
				a = crt;
			} else {
				b.next = crt;
				b = crt;
			}
			crt = next;
			if (next != null) {
				next = next.next;
			}
		}
		b.next = null;
		p1 = a;
		
		while (p1 != null && p1.next != pivot) { // short circuit
			p1 = p1.next;
		}
		
		result[0] = a;
		result[1] = p1;
		result[2] = pivot;
		result[3] = pivot.next;
		result[4] = b;
		
		return result;
	}
	
	public void printList(ListNode head) {
		ListNode crt = head;
		while (crt != null) {
			System.out.print(crt.val + ", ");
			crt = crt.next;
		}
		System.out.println();
	}
	
	public ListNode partitionList (ListNode head) {// a copy ref of head
		ListNode pivot = head;
		ListNode a = pivot;
		ListNode b = pivot;
		ListNode crt = pivot.next;
		ListNode next = crt.next;
		
		while (crt != null) {
			if (crt.val < pivot.val) {
				crt.next = a;
				a = crt;
			} else {
				b.next = crt;
				b = crt;
			}
			crt = next;
			if (next != null) {
				next = next.next;
			}
		}
		
		b.next = null;
		return a;
	}
	
	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		ListNode crt = head;
		int[] nodes = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		for (int i = 0; i < nodes.length; i ++) {
			ListNode newNode = new ListNode(nodes[i]);
			crt.next = newNode;
			crt = crt.next;
		}
		
		QuickSortList solution = new QuickSortList();
		
		//ListNode newHead = solution.partitionList(head);
		//solution.printList(newHead);

		ListNode newHead = solution.sortList(head);
		solution.printList(newHead);
	}
}

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
	 	next = null;
	}
}
