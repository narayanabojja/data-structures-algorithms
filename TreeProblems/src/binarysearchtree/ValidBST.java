package binarysearchtree;

public class ValidBST {

	/**
	 * https://leetcode.com/problems/validate-binary-search-tree/
	 * 
	 * Approach Define a range for each node, every node must satisfy a range of
	 * valid values. The root node is initially allowed to have any value within the
	 * range from negative infinity to positive infinity. Start with the root node
	 * and ensure its value is within the defined range. Recursively validate the
	 * subtrees. For the left subtree of a node, update the range to be from
	 * negative infinity to the node’s value. For the right subtree of a node,
	 * update the range to be from the node’s value to positive infinity. Ensure
	 * that each node’s value falls within its updated range. Recursively apply the
	 * same checks to the left and right children of each node. If all nodes satisfy
	 * their respective ranges, the tree is a BST and if any node fails the check,
	 * the tree is not a BST.
	 * 
	 * Time Complexity O(N), Each node in the tree is visited once during the
	 * inorder traversal.
	 * 
	 * Space Complexity O(N), The recursive call stack can go up to the depth of the
	 * tree and the ans list can also store N elements in the worst case.
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBST(TreeNode root) {
		// Helper function to validate the BST
		return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean validate(TreeNode node, long min, long max) {
		// Base case: if the node is null, return true
		if (node == null)
			return true;

		// Check if the node's value falls within the valid range
		if (node.data <= min || node.data >= max)
			return false;

		// Recursively validate the left subtree
		// Update the max value to the current node's value
		boolean leftIsValid = validate(node.left, min, node.data);

		// Recursively validate the right subtree
		// Update the min value to the current node's value
		boolean rightIsValid = validate(node.right, node.data, max);

		// Both subtrees must be valid for the tree to be a BST
		return leftIsValid && rightIsValid;
	}

	// Main method for testing
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(5);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(15);

		ValidBST solution = new ValidBST();

		System.out.println(solution.isBST(root)); // Output: false
	}

}
