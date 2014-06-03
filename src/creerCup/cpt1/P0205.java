package creerCup.cpt1;

public class P0205 {

	static Node createList(int value) {
		Node head = null;
		
		int digit;
		Node crt = null;
		
		while (value >= 10) {
			digit = value % 10;
			value = value / 10;
			
			Node newNode = new Node();
			newNode.data = digit;

			if (head == null) {
				head = newNode;
				crt = head;
			} else {
				crt.next = newNode;
				crt = newNode;
			}
		}
		 
		Node newNode = new Node();
		newNode.data = value;
		crt.next = newNode;
		
		return head;
	}
	
	static void printList(Node head) {
		Node crt = head;
		while (crt != null) {
			System.out.print(crt.data + ", ");
			crt = crt.next;
		}
	}
	
	public static void main(String args[]) {
		Node list1 = createList(32767);
		printList(list1);
	}
}

class Node {
	int data;
	Node next;
	
	Node() {
		data = -1; // dummy
		next = null;
	}
}