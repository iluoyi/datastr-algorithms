package dataStrct;

public class TrieTree {
	static class TrieNode {
		TrieNode[] children = new TrieNode[128];
		boolean leaf;
	}

	public static void insertString(TrieNode root, String s) {
		TrieNode v = root;
		for (char ch : s.toCharArray()) {
			TrieNode next = v.children[ch];
			if (next == null)
				v.children[ch] = next = new TrieNode();
			v = next;
		}
		v.leaf = true;
	}
	
	public boolean isPrefix(TrieNode root, String prefix) {
		return false;
	}
	
	public boolean contains(TrieNode root, String word) {
		return false;
	}

	public static void printSorted(TrieNode node, String s) {
		for (char ch = 0; ch < node.children.length; ch++) {
			TrieNode child = node.children[ch];
			if (child != null)
				printSorted(child, s + ch);
		}
		if (node.leaf) {
			System.out.println(s);
		}
	}

	// Usage example
	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		insertString(root, "world");
		insertString(root, "hi");
		insertString(root, "hello");
		printSorted(root, "");
	}

}
