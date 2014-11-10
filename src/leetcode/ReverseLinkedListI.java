package leetcode;

public class ReverseLinkedListI {
	 public ListNode reverse(ListNode head) {
		ListNode prev = null, crt = head, next;
		while (crt != null) {
			next = crt.next;
			crt.next = prev;
			prev = crt;
			crt = next;
		}
		return prev;
	}
	
	public static void main(String args[]) {
		int[] testInput = {1, 2, 3, 4, 5, 6, 7, 8};
		ListNode head = new ListNode(testInput[0]);
		ListNode crt = head;
		
		for (int i = 1; i < testInput.length; i ++) {
			crt.next = new ListNode(testInput[i]);
			crt = crt.next;
		}
		
		ReverseLinkedListI solution = new ReverseLinkedListI();
		head = solution.reverse(head);
		
		crt = head;
		while (crt != null) {
			System.out.print(crt.val + ", ");
			crt = crt.next;
		}
	}
}
