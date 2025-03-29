package binarysearchtree;

/**
 * Given the root of a binary search tree (BST) and an integer val.
 * 
 * Find the node in the BST that the node's value equals val and return the
 * subtree rooted with that node. If such a node does not exist, return null.
 * 
 */
public class SearchInBST {

	public static void main(String[] args) {
		// Creating a simple BST for demonstration
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		SearchInBST sol = new SearchInBST();

		TreeNode result = sol.searchBSTLoop(root, 2);
		if (result != null) {
			System.out.println("Node found with value: " + result.data);
		} else {
			System.out.println("Node not found");
		}

	}

	/**
	 * Time Complexity: O(log2(N)) : The time complexity is O(log2(N)) in a balanced
	 * BST since the search space is halved at each step. However, in the worst case
	 * (skewed tree), it can be O(N).
	 * 
	 * Space Complexity: O(1): The space complexity is O(1) as the search is
	 * performed iteratively without using additional space.
	 * 
	 * @param root
	 * @param val
	 * @return
	 */
	public TreeNode searchBSTLoop(TreeNode root, int val) {
		// Traverse the tree until we find the node
		// with the given value or reach the end
		while (root != null && root.data != val) {
			// Move to the left or right child
			// depending on the value comparison
			root = (root.data > val) ? root.left : root.right;
		}
		// Return the found node or null if not found
		return root;
	}

	/**
	 * Time complexity: O(h), where h is the height of the BST. Auxiliary Space:
	 * O(h)
	 * 
	 * @param root
	 * @param val
	 * @return
	 */
	public TreeNode searchBSTRecursion(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if (root.data == val) {
			return root;
		}
		if (val < root.data) {
			return searchBSTRecursion(root.left, val);
		} else {
			return searchBSTRecursion(root.right, val);
		}
	}
}
