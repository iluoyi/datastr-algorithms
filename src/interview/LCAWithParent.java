package interview;

import java.util.HashSet;

/**
 * By Zillow
 * 
 * @author Yi
 *
 */
public class LCAWithParent {
	/* PROBLEM STATEMENT:
	 
	The lowest common ancestor (LCA) of two nodes is the deepest node
	common to the lineage of both nodes. For example, in this tree...

	         R
	        / \
	       /   \ 
	      A     B
	     / \     \
	    C   D     E
	       / \
	      X   Y

	... the LCA of nodes A and B is the root R.
	... the LCA of nodes X and Y is the node D.
	... the LCA of nodes C and E is the node R.
	... the LCA of nodes C and Y is the node A.

	Please implement a method that returns the lowest common ancestor
	of two nodes given.

	You may not assume any organization for the tree, i.e. the tree 
	is _not_ a BST. However, the nodes do have a parent reference.

	*/

	public Node lowestCommonAncestor(Node foo, Node bar) {
	  // TODO!
	  if (foo == null || bar == null) return null; // null cases
	  
	  // parents of foo
	  HashSet<Node> parents = new HashSet<Node>();
	  Node crt = foo;
	  while (crt != null) {
	      parents.add(crt);
	      crt = crt.parent;
	  }
	  
	  // check the ancestor
	  crt = bar;
	  while (crt != null) {
	      if (parents.contains(crt)) {
	          return crt;
	      }
	      crt = crt.parent;
	  }
	  
	  return null;
	}

	public Node lowestCommonAncestor2(Node foo, Node bar) {
	  // TODO!
	  if (foo == null || bar == null) return null; // null cases
	  
	  // level of foo
	  int l1 = 1, l2 = 1;
	  Node crt = foo;
	  while (crt != null) {
	      crt = crt.parent;
	      l1 ++;
	  }
	  
	  // level of bar
	  crt = bar;
	  while (crt != null) {
	      crt = crt.parent;
	      l2 ++;
	  }
	  
	  // balance levels
	  Node p1, p2;
	  if (l1 != l2) {
	    p1 = l1 < l2 ? foo : bar; // lower level
	    crt = l1 < l2 ? bar : foo; // higher level
	    int diff = l1 < l2 ? l2 - l1 : l1 - l2;
	    for (int i = 0; i < diff; i ++) 
	        crt = crt.parent;
	    p2 = crt;
	  } else {
	     p1 = foo;
	     p2 = bar;
	  }
	  
	  
	  // find the lca
	  while (p1 != null && p2 != null) {
	      if (p1 == p2)
	         return p1;
	      else {
	          p1 = p1.parent;
	          p2 = p2.parent;
	      }
	  }
	  
	  return null;
	}

	public class Node {
	  Node left;
	  Node right;
	  Node parent; // we use this field
	}
}
