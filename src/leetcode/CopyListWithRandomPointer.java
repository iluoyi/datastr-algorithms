package leetcode;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
       
        RandomListNode crt, temp, newHead;
        
        // 1. copy the next field of the list
        crt = head;
        while (crt != null) {
        	temp = new RandomListNode(crt.label);
        	temp.next = crt.next;
        	crt.next = temp;
        	crt = temp.next;
        }

        // Because the tail pointer may point back to the front, we have to separate the
        // process of copying RandomPointers and the process of splitting the list!
        
        // 2. copy Random Pointers
        crt = head;
        while (crt != null) {
        	temp = crt.next;
        	if (crt.random != null)
        		temp.random = crt.random.next; // cause we don't want to point to the original list
        	crt = temp.next;
        }
        
        // 3. split the linked list
        crt = head;
        newHead = head.next;
        while (crt != null) {
        	temp = crt.next;
        	crt.next = temp.next;
        	crt = crt.next;
        	if (crt != null) {
        		temp.next = crt.next;
        	}
        }
        
        return newHead;
    }
}
