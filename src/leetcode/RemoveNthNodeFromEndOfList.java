package leetcode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev, slow, fast;
        
        prev = null;
        slow = head;
        fast = head;
        
        for (int i = 0; i < n; i ++) { // n steps
        	fast = fast.next;
        }
        
        while (fast != null) {
        	prev = slow;
        	slow = slow.next;
        	fast = fast.next;
        }
        
        if (prev == null) {// we should remove the head node
        	head = head.next;
        } else {
        	prev.next = slow.next;
        }
        
        return head;
    }
}
