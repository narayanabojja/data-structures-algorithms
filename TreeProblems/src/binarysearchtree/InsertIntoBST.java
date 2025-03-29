package binarysearchtree;

/**
 * Given the root node of a binary search tree (BST) and a value val to insert
 * into the tree. Return the root node of the BST after the insertion. It is
 * guaranteed that the new value does not exist in the original BST.
 */
public class InsertIntoBST {

	/**
	 * Time Complexity: O(H), where H is the height of the tree, which in the worst
	 * case can be N (for a skewed tree), but for a balanced BST, it will be log(N).
	 * Space Complexity: O(1) Only a constant amount of space is used to store the
	 * current node and the new node, regardless of the size of the input tree.
	 * 
	 * @param root
	 * @param val
	 * @return
	 */
	public TreeNode insertIntoBST(TreeNode root, int val) {
		// If the root is null, create a new node with the given value and return it
		if (root == null) {
			return new TreeNode(val);
		}

		// Traverse the tree to find the correct insertion point
		TreeNode current = root;
		while (true) {
			if (val < current.data) {
				// Move to the left subtree
				if (current.left == null) {
					current.left = new TreeNode(val);
					break;
				} else {
					current = current.left;
				}
			} else {
				// Move to the right subtree
				if (current.right == null) {
					current.right = new TreeNode(val);
					break;
				} else {
					current = current.right;
				}
			}
		}

		// Return the modified tree's root node
		return root;
	}

	// Helper function to print the tree in-order
	private void printInOrder(TreeNode root) {
		if (root == null)
			return;
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
	}

	public static void main(String[] args) {

		InsertIntoBST solution = new InsertIntoBST();

		// Create a sample BST: [4, 2, 7, 1, 3]
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		int val = 5;
		root = solution.insertIntoBST(root, val);

		// Print the BST in-order to verify the insertion
		solution.printInOrder(root); // Output should be: 1 2 3 4 5 7
	}

}
