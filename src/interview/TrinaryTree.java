package interview;
/**
 * This class implements a tri-nary tree with two methods insert and delete.
 * 
 * @author Yi Luo
 * 
 */
public class TrinaryTree {
	Node root; // this defines the root of this trinary tree

	/**
	 * The default constructor
	 */
	public TrinaryTree() {
		root = null;
	}
	
	/**
	 * This is the insert method, the input is an integer value.
	 */
	public void insert(int val) {
		if (root == null) { // if the tree is empty
			root = new Node(val);
		}
		else {
			Node prev = null;
			Node crt = root;
			// to locate where to insert this value
			while (crt != null) {
				prev = crt;
				if (val < crt.val) {
					crt = prev.left;
				} 
				else if (val > crt.val) {
					crt = prev.right;
				}
				else {
					crt = prev.mid;
				}
			}
			// try to insert this value
			Node newNode = new Node(val);
			if (val < prev.val) {
				prev.left = newNode;
			}
			else if (val > prev.val) {
				prev.right = newNode;
			}
			else {
				prev.mid = newNode;
			}
		}
	}
	
	/**
	 * This is the delete method. 
	 * It lookups the given value and delete the corresponding node, then it adjusts the tree to 
	 * satisfy the requirement of the tri-nary tree. 
	 * If it cannot find the value in the tree, this method returns false.
	 */
	public boolean delete(int val) {
		// to locate the Node which has the given value
		Node prevNode = null;
		Node crtNode = root;
		while (crtNode != null) {
			if (val > crtNode.val) {
				prevNode = crtNode;
				crtNode = crtNode.right;
			} 
			else if (val < crtNode.val) {
				prevNode = crtNode;
				crtNode = crtNode.left;
			}
			else {
				break;
			}
		}
		// if the tree is empty or contains no such value, it returns false
		if (crtNode == null) {
			return false;
		}
		// case 1: if there are duplicate nodes with the give value, delete the leaf node
		if (crtNode.mid != null){
			while (crtNode.mid != null) {
				prevNode = crtNode;
				crtNode = crtNode.mid;
			}
			prevNode.mid = null;
		}
		// if this node contains no mid child
		else {
			// case 2: if it has no right child
			if (crtNode.right == null) {
				if (prevNode == null) {// if it is the root
					root = crtNode.left;					
				} else {
					if (crtNode.val < prevNode.val) {
						prevNode.left = crtNode.left;
					} else {
						prevNode.right = crtNode.left;
					}
				}
			}
			// case 3: if it has both left and right children
			else {
				Node smallestNode = crtNode.right;
				Node momOfSmallestNode = crtNode;
				while (smallestNode.left != null) {
					momOfSmallestNode = smallestNode;
					smallestNode = smallestNode.left;
				}
				
				// replace the crtNode with this smallest Node
				crtNode.val = smallestNode.val;
				crtNode.mid = smallestNode.mid;
				
				if (momOfSmallestNode == crtNode) {
					crtNode.right = smallestNode.right;
				} else {
					momOfSmallestNode.left = smallestNode.right;
				}
			}
		}
		return true;
	}
	
	/**
	 * For my own testing.
	 */
	public static void main(String args[]) {
		int[] testInput = {5, 4, 9, 5, 7, 2, 2};
		//int[] testInput = {20, 10, 20, 40, 35, 47, 30, 38, 38, 45, 47, 80, 47, 39, 36, 37, 36};
		TrinaryTree newTree = new TrinaryTree();
		
		for (int i = 0; i < testInput.length; i ++) {
			newTree.insert(testInput[i]);
		}

		System.out.println(newTree.delete(5));
		
		newTree.printResults();
	}
	
	/**
	 * For testing: traverse the tree with "inorder".
	 */
	void inorder(Node crtNode) {
		if (crtNode != null) {
			inorder(crtNode.left);
			Node nextNode = crtNode;
			while (nextNode != null) {
				System.out.print(nextNode.val + ", ");
				nextNode = nextNode.mid;
			}
			inorder(crtNode.right);
		}
	}
	
	/**
	 * For testing: traverse the tree with "preorder".
	 */
	void preorder(Node crtNode) {
		if (crtNode != null) {
			Node nextNode = crtNode;
			while (nextNode != null) {
				System.out.print(nextNode.val + ", ");
				nextNode = nextNode.mid;
			}
			preorder(crtNode.left);
			preorder(crtNode.right);
		}
	}
	
	/**
	 * For testing: print out the result of inoder/preorder traversal
	 */
	void printResults() {
		inorder(this.root);
		System.out.println();
		preorder(this.root);
		System.out.println();
	}
}

/**
 * This inner class defines the Node of the tri-nary tree
 */
class Node {
	int val;
	Node left;
	Node mid;
	Node right;
	
	/**
	 * The default constructor
	 */
	public Node(int val) {
		this.val = val;
		left = null;
		mid = null;
		right = null;
	}
}