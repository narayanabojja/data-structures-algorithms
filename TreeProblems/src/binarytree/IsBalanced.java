package binarytree;

/**
 * Given a binary tree root, find if it is height-balanced or not. A tree is
 * height-balanced if the difference between the heights of left and right
 * subtrees is not more than one for all nodes of the tree.
 */
public class IsBalanced {

	/**
	 * Time Complexity: O(N^2) where N is the number of nodes in the Binary Tree.
	 * For each node in the Binary Tree, all other nodes are traversed to calculate
	 * its height, resulting in a nested traversal structure, leading to O(N)
	 * operations for each of the N nodes, hence O(N * N) = O(N^2).
	 * 
	 * Space Complexity: O(1) as no additional data structures or memory is
	 * allocated.
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalancedBruteForce(TreeNode root) {
		// If the tree is empty, it's balanced
		if (root == null) {
			return true;
		}

		// Calculate the height of left and right subtrees
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		// Check if the absolute difference in heights
		// of left and right subtrees is <= 1
		if (Math.abs(leftHeight - rightHeight) <= 1 && isBalancedBruteForce(root.left)
				&& isBalancedBruteForce(root.right)) {
			return true;
		}

		// If any condition fails, the tree is unbalanced
		return false;
	}

	// Function to calculate the height of a subtree
	public int getHeight(TreeNode root) {
		// Base case: if the current node is NULL,
		// return 0 (height of an empty tree)
		if (root == null) {
			return 0;
		}

		// Recursively calculate the height
		// of left and right subtrees
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		// Return the maximum height of left and right subtrees
		// plus 1 (to account for the current node)
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(6);
		root.left.right.right.right = new TreeNode(7);

		// Creating an instance of the Solution class
		IsBalanced solution = new IsBalanced();

		// Checking if the tree is balanced
		if (solution.isBalancedBruteForce(root)) {
			System.out.println("The tree is balanced.");
		} else {
			System.out.println("The tree is not balanced.");
		}
		// Checking if the tree is balanced
		if (solution.isBalanced(root)) {
			System.out.println("The tree is balanced.");
		} else {
			System.out.println("The tree is not balanced.");
		}
	}

	/**
	 * Checks if the binary tree is balanced. A binary tree is considered balanced
	 * if the height difference between the left and right subtrees of every node is
	 * at most 1.
	 * 
	 * @param root The root node of the binary tree.
	 * @return true if the tree is balanced, false otherwise. Complexity Analysis
	 *         Time Complexity: O(N) where N is the number of nodes in the Binary
	 *         Tree.
	 * 
	 *         Space Complexity: O(N) because of recursive stack space used.
	 */
	public boolean isBalanced(TreeNode root) {
		// Call the recursive helper method to check balance status.
		// If the heightDifference() returns -1, the tree is unbalanced.
		return dfsHeight(root) != -1;
	}

	/**
	 * Recursive method to calculate the height of the tree. Returns -1 if the tree
	 * is unbalanced, otherwise returns the height of the tree.
	 * 
	 * @param root The current node of the tree.
	 * @return The height of the tree if balanced, -1 if unbalanced.
	 */
	private int dfsHeight(TreeNode root) {
		// Base case: If the current node is null, the height of an empty tree is 0.
		if (root == null)
			return 0;

		// Recursively calculate the height of the left subtree.
		int leftHeight = dfsHeight(root.left);
		// If the left subtree is unbalanced, propagate the unbalance status.
		if (leftHeight == -1)
			return -1;

		// Recursively calculate the height of the right subtree.
		int rightHeight = dfsHeight(root.right);
		// If the right subtree is unbalanced, propagate the unbalance status.
		if (rightHeight == -1)
			return -1;

		// Check if the difference in height between the left and right subtrees is
		// greater than 1.
		// If the difference is greater, the tree is unbalanced.
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;

		// Return the height of the tree rooted at the current node.
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
