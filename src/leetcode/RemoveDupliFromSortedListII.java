package leetcode;

public class RemoveDupliFromSortedListII {
	// recursive method: O(n) / O(1)
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode next = head.next;
        
        if (head.val == next.val) {
        	while (next != null && next.val == head.val) {
        		next = next.next;
        	}
        	return deleteDuplicates(next);
        } else {
        	head.next = deleteDuplicates(next);
        }
        return head;
    }
	
	//iterative method
	public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val; // cache the value
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }            
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
	
	public static void main(String args[]) {
		int[] testInput = {1, 1, 2, 3, 4, 4, 5};
		ListNode head = new ListNode(testInput[0]);
		ListNode crt = head;
		
		for (int i = 1; i < testInput.length; i ++) {
			crt.next = new ListNode(testInput[i]);
			crt = crt.next;
		}
		
		RemoveDupliFromSortedListII solution = new RemoveDupliFromSortedListII();
		head = solution.deleteDuplicates(head);
		
		crt = head;
		while (crt != null) {
			System.out.print(crt.val + ", ");
			crt = crt.next;
		}
	}
}
