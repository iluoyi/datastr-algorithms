package leetcode;

public class PartionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
        	return null;
        }
        
        ListNode crt = head, newHead;
        ListNode ss = null, se = ss, ls = null, le = ls;
        
        while (crt != null) {
        	if (crt.val < x) {
        		if (ss == null) {
        			ss = crt;
        			se = ss;
        		} else {
        			se.next = crt;
        			se = se.next;
        		}
        	} else {
        		if (ls == null) {
        			ls = crt;
        			le = ls;
        		} else {
        			le.next = crt;
        			le = le.next;
        		}
        	}
        	crt = crt.next;
        }
        
        newHead = ss;
        if (ss == null) newHead = ls; else se.next = ls;
        if (ls != null) le.next = null;
        
        return newHead;
    }
    
    public static void main(String args[]) {
    	PartionList solution = new PartionList();
    	ListNode head = new ListNode(1);
    	ListNode crt = head; // 1, 4, 3, 2, 5, 2
//    	crt.next = new ListNode(4);
//    	crt = crt.next;
//    	crt.next = new ListNode(3);
//    	crt = crt.next;
//    	crt.next = new ListNode(2);
//    	crt = crt.next;
//    	crt.next = new ListNode(5);
//    	crt = crt.next;
//    	crt.next = new ListNode(2);
    	
    	crt = head;
    	while (crt != null) {
    		System.out.print(crt.val + ", ");
    		crt = crt.next;
    	}
    	
    	System.out.println();
    	crt = solution.partition(head, 0);
    	
    	while (crt != null) {
    		System.out.print(crt.val + ", ");
    		crt = crt.next;
    	}
    }
}
