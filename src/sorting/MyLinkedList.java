package sorting;

public class MyLinkedList {
	ListNode head, tail;
	
	public MyLinkedList() {
		head = null;
		tail = head;
	}
	
	public void insert(int x) {
		if (head == null) {
			head = new ListNode(x);
		}
	}
}
