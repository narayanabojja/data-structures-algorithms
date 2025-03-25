package binarytree;

/**
 * Given the roots of two binary trees p and q, write a function to check if
 * they are the same or not. Two binary trees are considered the same if they
 * are structurally identical, and the nodes have the same value.
 */
public class SameTree {
	/**
	 * Complexity Analysis Time Complexity: O(N) Visit each node exactly once during
	 * the traversal, where N is the number of nodes in the tree.
	 * 
	 * Space Complexity: O(h) The space complexity is determined by the recursion
	 * stack, which can go as deep as the height of the tree h.
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
		// If both nodes are null, the trees are the same
		if (p == null && q == null) {
			return true;
		}

		// If one of the nodes is null, the trees are not the same
		if (p == null || q == null) {
			return false;
		}

		// If the values of the nodes are different, the trees are not the same
		if (p.key != q.key) {
			return false;
		}

		// Recursively check the left and right subtrees
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		// Example usage
		SameTree solution = new SameTree();

		// Creating two sample trees
		BinaryTreeNode tree1 = new BinaryTreeNode(1);
		tree1.left = new BinaryTreeNode(2);
		tree1.right = new BinaryTreeNode(3);

		BinaryTreeNode tree2 = new BinaryTreeNode(1);
		tree2.left = new BinaryTreeNode(2);
		tree2.right = new BinaryTreeNode(3);

		// Checking if the trees are identical
		boolean result = solution.isSameTree(tree1, tree2);
		System.out.println("Are the trees identical? " + result); // Output: true
	}
}