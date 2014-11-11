package sorting;

public class MyLinkedList {
	ListNode head, tail;
	
	public MyLinkedList() {
		head = null;
		tail = head;
	}
	
	public MyLinkedList(int[] array) {
		this();
		for (int i = 0; i < array.length; i ++)
			this.insert(array[i]);
	}
	
	public void insert(int x) {
		if (head == null) {
			head = new ListNode(x);
			tail = head;
		} else {
			tail.next = new ListNode(x);
			tail = tail.next;
		}
	}
	
	public ListNode getHead() {
		return this.head;
	}
	
	public void print() {
		ListNode crt = head;
		while (crt != null) {
			System.out.print(crt.val + ", ");
			crt = crt.next;
		}
		System.out.println();
	}	
}
