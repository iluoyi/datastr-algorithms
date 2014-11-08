package sorting;


public class SelectionSortList {
	public static void selectionSort(ListNode head) {
		
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

	}
}
