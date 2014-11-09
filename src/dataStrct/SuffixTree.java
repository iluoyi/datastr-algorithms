package dataStrct;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * From CTCI 5th Edition
 * 
 * @author yiluo
 *
 */
public class SuffixTree {
	private class SuffixTreeNode {
		char value;
		HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>(); // which char
		ArrayList<Integer> indexes = new ArrayList<Integer>(); // which index of the same char
		
		public void insertString(String s, int index) {
			indexes.add(index);
			if (s != null && s.length() > 0) {
				value = s.charAt(0);
				SuffixTreeNode child = null;
				if (children.containsKey(value)) {
					child = children.get(value);
				} else {
					child = new SuffixTreeNode();
					children.put(value, child);
				}
				String remainder = s.substring(1);
				child.insertString(remainder, index);
			}
		}
		
		public ArrayList<Integer> search(String s) {
			if (s != null) {
				if (s.length() == 0) {
					return indexes; // might be more than one indexes
				} else {
					char first = s.charAt(0);
					if (children.containsKey(first)) {
						String remainder = s.substring(1);
						return children.get(first).search(remainder);
					}
				}
			} 
			
			return null;
		}
	}
	
	SuffixTreeNode root = new SuffixTreeNode();
	
	/**
	 * Constructor
	 * @param s
	 */
	public SuffixTree(String s) {
		for (int i = 0; i < s.length(); i ++) {
			String subStr = s.substring(i);
			root.insertString(subStr, i);
		}
	}
	
	public ArrayList<Integer> search(String s) {
		return root.search(s);
	}
	
	public static void main(String args[]) {
		SuffixTree sTree = new SuffixTree("bibsbs");
		System.out.println(sTree.search("bs"));
	}
}
