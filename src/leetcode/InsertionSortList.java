package leetcode;

public class InsertionSortList {
	
	/**
	 * O(n^2)
	 */
	public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode crt = head, target, temp;
        
        while (crt != null) {
            target = dummy; // reset to the left side
            while (target.next != null && target.next.val < crt.val) {
                target = target.next;
            } // until we find the place to insert
            
            temp = crt.next;
            crt.next = target.next;
            target.next = crt;
            crt = temp;
        }

        return dummy.next;
    }
}
