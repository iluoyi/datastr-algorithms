package dataStrct;

public class LinkedList {
	ListNode head;
	ListNode tail;
	
	public LinkedList() {
		head = new ListNode();// a dummy node in the head
		tail = head;
	}
	
	public void insert(int value) {
		ListNode newNode = new ListNode(value);
		tail.nextNode = newNode;
		tail = tail.nextNode;
	}
	
	public void reverse() {
		ListNode prev = head.nextNode;
		ListNode crt = prev.nextNode;
		ListNode next = crt.nextNode;
		
		prev.nextNode = null;
		while (next != null) {
			crt.nextNode = prev;
			prev = crt;
			crt = next;
			next = next.nextNode;
		}
		crt.nextNode = prev;
		head.nextNode = crt;
	}
	
	public void printResults() {
		ListNode crt = head.nextNode;
		while (crt != null) {
			System.out.print(crt.data + ", ");
			crt = crt.nextNode;
		}
		System.out.println();
	}
	
	/**
	 * For my own testing.
	 */
	public static void main(String args[]) {
		int[] testInput = {5, 4, 9, 5, 7, 2, 2};
		LinkedList list = new LinkedList();
		
		for (int i = 0; i < testInput.length; i ++) {
			list.insert(testInput[i]);
		}

		list.printResults();
		list.reverse();
		list.printResults();
	}
}

class ListNode {
	int data;
	ListNode nextNode;
	
	ListNode() {
		data = 0;
		nextNode = null;
	}
	
	ListNode(int value) {
		data = value;
		nextNode = null;
	}
}
