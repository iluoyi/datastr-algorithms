package leetcode;

import java.util.ArrayList;

/**
 * 0. naive merge (for loop): O(n*k*k)
 * 
 * 1. divide-and-conquer: O(n*klogk) <- T(n) = 2T(k/2) + O(n*k) [not constant n, it grows in every merge] 
 * 2. min-heap: O(n*klogk)
 * 
 * @author yiluo
 *
 */
public class MergeKSortedList {
	/**
	 * Divide-and-conquer
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		return helper(lists, 0, lists.size() - 1);
	}

	private ListNode helper(ArrayList<ListNode> lists, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			return merge(helper(lists,l,m),helper(lists,m+1,r));
	    }
	    return lists.get(l);
	}
	private ListNode merge(ListNode left, ListNode right) {
		ListNode dummyHead = new ListNode(0);
		ListNode crt = dummyHead;
		
		while (left != null && right != null) {
			if (left.val <= right.val) {
				crt.next = left;
				left = left.next;
			} else {
				crt.next = right;
				right = right.next;
			}
			crt = crt.next;
		}
		
		crt.next = (left == null) ? right : left;
		return dummyHead.next;
	}
	
	/**
	 * Heap method
	 */
//	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
//        public int compare(ListNode left, ListNode right) {
//            if (left == null) {
//                return 1;
//            } else if (right == null) {
//                return -1;
//            }
//            return left.val - right.val;
//        }
//    };
//    
//    public ListNode mergeKLists(ArrayList<ListNode> lists) {
//        if (lists == null || lists.size() == 0) {
//            return null;
//        }
//        
//        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
//        for (int i = 0; i < lists.size(); i++) {
//            if (lists.get(i) != null) {
//                heap.add(lists.get(i));
//            }
//        }
//        
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//        while (!heap.isEmpty()) {
//            ListNode head = heap.poll();
//            tail.next = head;
//            tail = head;
//            if (head.next != null) {
//                heap.add(head.next);
//            }
//        }
//        return dummy.next;
//    }
}
