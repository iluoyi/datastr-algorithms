package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 1. clone nodes;
 * 2. clone neighbors;
 * 
 * @author CSE User
 *
 */
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;
		
		// clone nodes with BFS
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		
		queue.offer(node);
		nodeMap.put(node, new UndirectedGraphNode(node.label));
		
		UndirectedGraphNode crtNode = null;
		while (!queue.isEmpty()) {
			crtNode = queue.poll();
			for (UndirectedGraphNode oneNode : crtNode.neighbors) {
				if (!nodeMap.containsKey(oneNode)) {
					nodeMap.put(oneNode, new UndirectedGraphNode(oneNode.label));
					queue.offer(oneNode);
				}
			}
		}
		
		// clone neighbors
		for (UndirectedGraphNode eachNode : nodeMap.keySet()) { // eachNode = each original node
			for (UndirectedGraphNode neighbor : eachNode.neighbors) {
				nodeMap.get(eachNode).neighbors.add(nodeMap.get(neighbor));
			}
		}
		
		return nodeMap.get(node);
	}
}
