package leetcode;


public class ReverseNodesInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 0) {
			return head;
		}
		
		int len = 0; // the length of the list
		ListNode crt = head;
		ListNode next, pre, last, newHead;

		while (crt != null) {
			len++;
			crt = crt.next;

		}
		int iteration = len / k;

		newHead = null;
		if (iteration > 0) {
			last = null;	
			for (int i = 0; i < iteration; i++) {
				crt = head;
				next = crt.next;
				head.next = null;
				for (int j = 0; j < k - 1; j++) {
					pre = crt;
					crt = next;
					next = crt.next;
					crt.next = pre;
				}
				if (last != null) {
					last.next = crt;
				}
				last = head;
				head = next;
				
				if (i == 0) {
					newHead = crt;
				}
			}
			if (head != null) { // if there are remaining nodes
				last.next = head;
			}
			return newHead;
		} else {
			return head;
		}
	}

	public static void main(String args[]) {
		int[] testInput = {1, 2, 3, 4, 5, 6, 7, 8};
		ListNode head = new ListNode(testInput[0]);
		ListNode crt = head;
		
		for (int i = 1; i < testInput.length; i ++) {
			crt.next = new ListNode(testInput[i]);
			crt = crt.next;
		}
		int k = 9;
		
		ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
		head = solution.reverseKGroup(head, k);
		
		crt = head;
		while (crt != null) {
			System.out.print(crt.val + ", ");
			crt = crt.next;
		}
	}
}
