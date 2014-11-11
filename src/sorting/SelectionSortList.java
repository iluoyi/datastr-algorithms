package sorting;

/**
 * O(n^2)
 * 
 * @author Yi
 *
 */
public class SelectionSortList {
	public static void selectionSort(ListNode head) {
		if (head != null) {
			ListNode crt = head, min;
			while (crt != null) {
				min = getMin(crt);
				if (min != crt) { // swap
					int temp = min.val;
					min.val = crt.val;
					crt.val = temp;
				}
				crt = crt.next;
			}
		}
	}
	
	public static ListNode getMin(ListNode head) {
		assert head != null;
		
		ListNode crt = head.next;
		ListNode min = head;
		while (crt != null) {
			if (crt.val < min.val) {
				min = crt;
			}
			crt = crt.next;
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		MyLinkedList linkedList = new MyLinkedList(list);
		linkedList.print();
		selectionSort(linkedList.getHead());
		linkedList.print();
	}
}
