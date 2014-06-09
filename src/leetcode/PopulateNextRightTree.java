package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightTree {
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
					if (next == null) {
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
}
