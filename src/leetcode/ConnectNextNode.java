package leetcode;

import java.util.LinkedList;

public class ConnectNextNode {
	public void connect(TreeLinkNode root) {
        if (root != null) {
        	LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        	queue.offer(root);
        	
        	while (!queue.isEmpty()) {
        		
        	}
        	
        }
    }
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}