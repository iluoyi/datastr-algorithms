package leetcode;

public class RemoveDupliFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode crt = head;
        ListNode next = crt.next;
        
        while (next != null) {
        	while (next != null && next.val == crt.val) {
        		next = next.next;
        	}
        	if (next != null) {
        		crt.next = next;
        		crt = next;
        		next = crt.next;
        	} else {
        		crt.next = null;
        	}
        }
        
        return head;
    }
	
	public static void main(String args[]) {
		int[] testInput = {1, 1};
		ListNode head = new ListNode(testInput[0]);
		ListNode crt = head;
		
		for (int i = 1; i < testInput.length; i ++) {
			crt.next = new ListNode(testInput[i]);
			crt = crt.next;
		}
		
		RemoveDupliFromSortedList solution = new RemoveDupliFromSortedList();
		head = solution.deleteDuplicates(head);
		
		crt = head;
		while (crt != null) {
			System.out.print(crt.val + ", ");
			crt = crt.next;
		}
	}
}
