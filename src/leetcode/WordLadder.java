package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	// one-direction BFS
	public int ladderLength(String start, String end, Set<String> dict) {
		if (dict == null || dict.size() == 0) {
			return 0;
		}
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		dict.remove(start);
		int len = start.length();
		
		String word, temp;
		int size, level;
		
		level = 1;
		while (!queue.isEmpty()) {
			size = queue.size();
			for (int k = 0; k < size; k ++) {
				word = queue.poll();
				for (char c = 'a'; c <= 'z'; c ++) {
					for (int i = 0; i < len; i ++) {
						if (word.charAt(i) == c) continue;
						temp = generateWord(word, i, c);
						
						if (temp.equals(end)) return level + 1;
						if (dict.contains(temp)) {
							queue.offer(temp);
							dict.remove(temp);
						}
					}
				}
			}
			level ++;
		}
		return 0;
	}
	
	private String generateWord(String origStr, int index, char c) {
		char[] charAry = origStr.toCharArray();
		charAry[index] = c;
		return new String(charAry);
	}
	
//	Yi's initial implementation with shortest path idea, which is not efficient
//	final int MAX_INT = 1000000;
//	public int ladderLength(String start, String end, Set<String> dict) {
//		int m = dict.size() + 2;
//		int[][] matrix = new int[m][m];
//		
//		ArrayList<String> strList = new ArrayList<String>();
//		strList.add(start);
//		strList.addAll(dict);
//		strList.add(end);
//		
//		for (int i = 0; i < strList.size(); i ++) {
//			for (int j = 0; j < strList.size(); j ++) {
//				matrix[i][j] = getDistance(strList.get(i), strList.get(j));
//			}
//		}
//		
//		int dist = dijkstra(matrix, 0, m - 1);
//		return dist >= MAX_INT ? 0 : dist + 1;
//	}
//	
//	private int getDistance(String str1, String str2) {
//		int dist = 0;
//		for (int i = 0; i < str1.length(); i ++) {
//			if (str1.charAt(i) != str2.charAt(i)) {
//				dist ++;
//				if (dist > 1) {
//					return MAX_INT;
//				}
//			}
//		}
//		return dist; // can only be 0 or 1
//	}
//	
//	private int dijkstra(int[][] matrix, int source, int target) {
//		Set<Integer> nodes = new HashSet<Integer>();
//		int n = matrix.length;
//		int[] minDist = new int[n];
//		minDist[0] = 0;
//		
//		for (int i = 1; i < n; i ++) {
//			minDist[i] = matrix[0][i];
//			nodes.add(i);
//		}
//		
//		int minNode = 0;
//		while (!nodes.isEmpty()) {
//			minNode = getMinNode(minDist, nodes); // can be optimized
//			if (minNode == target) break; // terminate
//			nodes.remove(minNode);
//			
//			for (int i = 1; i < n; i ++) {
//				if (matrix[minNode][i] + minDist[minNode] < minDist[i]) {
//					minDist[i] = matrix[minNode][i] + minDist[minNode];
//				}
//			}
//		}
//		
//		return minDist[target];
//	}
//	
//	private int getMinNode(int[] minDist, Set<Integer> nodes) {
//		int index = 0;
//		int min = Integer.MAX_VALUE;
//		for (Integer i : nodes) {
//			if (minDist[i] < min) {
//				min = minDist[i];
//				index = i;
//			}
//		}
//		return index;
//	}
	
	public static void main(String[] args) {
		WordLadder solution = new WordLadder();
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("log");
		dict.add("lot");
		dict.add("dog");
		dict.add("hot");
		dict.add("dot");
		System.out.println(solution.ladderLength(start, end, dict));
	}
}
