package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightTreeII {
	
	/**
	 * O(n) with a Queue
	 * 
	 */
	public void connect(TreeLinkNode root) {
        if (root != null) {    
			Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
			
			queue.offer(root);
			queue.offer(null);
			root.next = null;
			
			TreeLinkNode crt, next;
			while (!queue.isEmpty()) {
				crt = queue.poll();
				next = queue.peek();
				
				if (crt == null) {
					if (next == null) {// queue.peek() returns null, means nothing is there any more
						break;
					}
					queue.offer(null);
				} else {
					crt.next = next;
					if (crt.left != null) {
						queue.offer(crt.left);
					}
					if (crt.right != null) {
						queue.offer(crt.right);
					}
				}
			}
		}
    }
	
	/**
	 * O(n)/O(1)
	 * make use of the .next field
	 * 
	 * @param root
	 */
	public void connect1(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		TreeLinkNode parent = root;
		TreeLinkNode pre;
		TreeLinkNode next;
		while (parent != null) {
			pre = null;
			next = null;
			while (parent != null) {
				if (next == null) {
					next = (parent.left != null) ? parent.left : parent.right; // next start point
				}

				if (parent.left != null) {
					if (pre != null) {
						pre.next = parent.left;
						pre = pre.next;
					} else {
						pre = parent.left;
					}
				}

				if (parent.right != null) {
					if (pre != null) {
						pre.next = parent.right;
						pre = pre.next;
					} else {
						pre = parent.right;
					}
				}
				parent = parent.next;
			}
			parent = next;
		}
	}
}
