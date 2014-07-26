package dataStrct;

public class MyLinkedList<E> extends MyAbstractList<E> {
	private Node<E> head, tail;

	/** Create a default list */
	public MyLinkedList() {
	}

	/** Create a list from an array of objects */
	public MyLinkedList(E[] objects) {
		super(objects);
	}

	/** Return the head element in the list */
	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return head.element;
		}
	}

	/** Return the last element in the list */
	public E getLast() {
		if (size == 0) {
			return null;
		} else {
			return tail.element;
		}
	}

	/** Add an element to the beginning of the list */
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e); // Create a new node
		newNode.next = head; // link the new node with the head
		head = newNode; // head points to the new node
		size++; // Increase list size

		if (tail == null) // the new node is the only node in list
			tail = head;
	}

	/** Add an element to the end of the list */
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e); // Create a new for element e

		if (tail == null) {
			head = tail = newNode; // The new node is the only node in list
		} else {
			tail.next = newNode; // Link the new with the last node
			tail = tail.next; // tail now points to the last node
		}

		size++; // Increase size
	}

	/**
	 * Add a new element at the specified index in this list The index of the
	 * head element is 0
	 */
	public void add(int index, E e) {
		if (index == 0) {
			addFirst(e);
		} else if (index >= size) {
			addLast(e);
		} else {
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
		}
	}

	/**
	 * Remove the head node and return the object that is contained in the
	 * removed node.
	 */
	public E removeFirst() {
		if (size == 0) {
			return null;
		} else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null) {
				tail = null;
			}
			return temp.element;
		}
	}

	/**
	 * Remove the last node and return the object that is contained in the
	 * removed node.
	 */
	public E removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> current = head;

			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}

			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	/**
	 * Remove the element at the specified position in this list. Return the
	 * element that was removed from the list.
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	/** Override toString() to return elements in the list */
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", "); // Separate two elements with a comma
			} else {
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}

	/** Clear the list */
	public void clear() {
		head = tail = null;
		size = 0; // this is missing from the 8th edition of the book!
	}

	/** Return true if this list contains the element e */
	public boolean contains(E e) {
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/** Return the element from this list at the specified index */
	public E get(int index) {
		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return head.element;
		} else if (index == size - 1) {
			return tail.element;
		} else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			return current.element;
		}
	}

	/**
	 * Return the index of the head matching element in this list. Return -1 if
	 * no match.
	 */
	public int indexOf(E e) {
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e)) {
				return i;
			}
			current = current.next;
		}
		return -1;
	}

	/**
	 * Return the index of the last matching element in this list Return -1 if
	 * no match.
	 */
	public int lastIndexOf(E e) {
		Node<E> current = head;
		int lastIndex = -1;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e)) {
				lastIndex = i;
			}
			current = current.next;
		}
		return lastIndex;
	}

	/**
	 * Replace the element at the specified position in this list with the
	 * specified element.
	 */
	public E set(int index, E e) {
		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return head.element;
		} else if (index == size - 1) {
			return tail.element;
		} else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			E oldElement = current.element;
			current.element = e;
			return oldElement;
		}
	}
	
	public MyLinkedList<E> extractSublist(int start, int end) {
		if (start < 0 || start > size - 1 || end < 0 || end > size - 1 || start > end) {
			return null;
		} else {
			MyLinkedList<E> sublist = new MyLinkedList<E>();
			E tempElement = null;
			for (int i = start; i <= end; i ++) {
				tempElement = this.remove(start);
				sublist.addLast(tempElement);
			}
			return sublist;
		}
	}
	
	public void prepend(MyLinkedList<E> prefix) {
		if (prefix != null) {
			int preSize = prefix.size();
			E tempElement = null;
			for (int i = 0; i < preSize; i ++) {
				tempElement = prefix.removeLast();
				this.addFirst(tempElement);
		}
		}
	}

	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}
	
	// just for testing
	public static void main(String args[]) {
		Integer[] testIntList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		MyLinkedList<Integer> testList = new MyLinkedList<Integer>(testIntList);
		testList.add(11);
		System.out.println(testList.toString());
		System.out.println("contains 5: " + testList.contains(5));
		System.out.println("contains 55: " + testList.contains(55));
		System.out.println("get index = 7: " + testList.get(7));
		System.out.println(testList.remove(8));
		System.out.println(testList.remove(new Integer(7)));
		System.out.println(testList.toString());
		testList.addFirst(7);
		testList.addLast(7);
		System.out.println(testList.toString());
		System.out.println(testList.indexOf(7));
		System.out.println(testList.lastIndexOf(7));
		MyLinkedList<Integer> subList = testList.extractSublist(0, 5);
		System.out.println(subList.toString());
		System.out.println(testList.toString());
		subList.prepend(testList);
		System.out.println(subList.toString());
	}
}
