package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


/**
 * 1. create Adjacent List (not matrix which requires O(n^2)), use 'a'-'z' techniques;
 * 2. use BFS to find the shortest path to "end" node;
 * 3. use DFS to rebuild the path.
 * 
 * @author yiluo
 *
 */
public class WordLadderII {
	
	public static void main(String[] args) {
		WordLadderII solution = new WordLadderII();
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("log");
		dict.add("lot");
		dict.add("dog");
		dict.add("hot");
		dict.add("dot");
		
		List<List<String>> results = solution.findLadders(start, end, dict);
		
		for (List<String> list : results) {
			System.out.println(list);
		}
	}
	
	// optimization 2: build Adjacent List in the beginning
	private HashMap<String, ArrayList<String>> buildAdjacentList(String start, String end, Set<String> dict) {
		HashMap<String, ArrayList<String>> adjMap = new HashMap<String, ArrayList<String>>();
		List<String> wordList = new ArrayList<String>(dict);
		wordList.add(start);
		wordList.add(end);
		int len = start.length();
		String temp;
		
		for (String word : wordList) {
			adjMap.put(word, new ArrayList<String>());
			for (char c = 'a'; c <= 'z'; c ++) {
				for (int i = 0; i < len; i ++) {
					if (word.charAt(i) == c) continue;
					temp = generateWord(word, i, c);
					if (dict.contains(temp) || temp.equals(end)) {
						adjMap.get(word).add(temp);
					}
				}
			}
		}
		
		return adjMap;
	}
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> results = new ArrayList<List<String>>();
		
		if (dict == null || dict.size() == 0) {
			return results;
		}
		
		Queue<WordNode> queue = new LinkedList<WordNode>();
		WordNode startNode = new WordNode(null, start);
		
		queue.offer(startNode);
		
		int size = 0;
		boolean found = false;
		WordNode crtNode, adjNode;
		Set<String> visited = new HashSet<String>(), toBeVisited = new HashSet<String>();
		
		HashMap<String, ArrayList<String>> adjMap = buildAdjacentList(start, end, dict);
		ArrayList<String> adjList;
		
		while (!queue.isEmpty() && !found) {
			size = queue.size();
			toBeVisited.clear();
			for (int k = 0; k < size; k ++) {
				crtNode = queue.poll();
				visited.add(crtNode.val);
				
				adjList = adjMap.get(crtNode.val); // get the adjList
//				System.out.println(crtNode.val + ", " + adjList);
				for (String adjWord : adjList) {
					if (!visited.contains(adjWord)) {
						adjNode = new WordNode(crtNode, adjWord);
						if (adjWord.equals(end)) {
							found = true;
							results.add(findPath(adjNode));
						}
						queue.add(adjNode);
						toBeVisited.add(adjWord);
					}
				}
			}
			visited.addAll(toBeVisited);
		}
		return results;
	}
	
	private LinkedList<String> findPath(WordNode crt) {
		LinkedList<String> path = new LinkedList<String>();
		while (crt != null) {
			path.addFirst(crt.val);
			crt = crt.pre;
		}
		return path;
	}
	
	private String generateWord(String origStr, int index, char c) {
		char[] charAry = origStr.toCharArray();
		charAry[index] = c;
		return new String(charAry);
	}
	
	private class WordNode {
		WordNode pre;
		String val;
		
		WordNode(WordNode pre, String val) {
			this.pre = pre;
			this.val = val;
		}
	}
}


