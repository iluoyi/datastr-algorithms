package leetcode;


/**
 * naive: O(nlogn)
 * 
 * best: O(n)  <-- f**king neat! bottom-up method
 * 
 * 
 * @author yiluo
 *
 */
public class ConvertSortedListToBST {
	private ListNode crt = null;
	
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        crt = head;
        while (crt != null) {
        	crt = crt.next;
        	len ++;
        }
        crt = head;
        return sortedListToBST(0, len - 1);
    }
    
    // bottom-up method
    private TreeNode sortedListToBST(int left, int right) {
    	if (left > right) return null;
    	
    	int mid = left + (right - left) / 2; // avoids overflow!
    	TreeNode leftChild = sortedListToBST(left, mid - 1);
    	TreeNode root = new TreeNode(crt.val);
    	crt = crt.next;
    	TreeNode rightChild = sortedListToBST(mid + 1, right);
    	root.left = leftChild;
    	root.right = rightChild;
    	return root;
    }
    
    public static void main(String args[]) {
    	ConvertSortedListToBST solution = new ConvertSortedListToBST();
    	ListNode head = new ListNode(3);
    	ListNode temp = new ListNode(5);
    	head.next = temp;
    	temp.next = new ListNode(8);
    	
    	TreeNode treeHead = solution.sortedListToBST(head);
    	System.out.println(treeHead.val);
    	System.out.println(treeHead.left.val);
    	System.out.println(treeHead.right.val);
    }
}
