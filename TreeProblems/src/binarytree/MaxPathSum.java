package binarytree;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/ A path in a
 * binary tree is a sequence of nodes where each pair of adjacent nodes in the
 * sequence has an edge connecting them. A node can only appear in the sequence
 * at most once. Note that the path does not need to pass through the root.
 * 
 * The path sum of a path is the sum of the node's values in the path.
 * 
 * Given the root of a binary tree, return the maximum path sum of any non-empty
 * path.
 * 
 */

public class MaxPathSum {
	BinaryTreeNode root;
	private int maxSum;

	/**
	 * Time and Space Complexity - Time Complexity: (O(N)), since we visit each node
	 * once. - Space Complexity: (O(H)), where (H) is the height of the tree (due to
	 * recursion stack).
	 * 
	 * @param root
	 * @return
	 */
	public int maxPathSum(BinaryTreeNode root) {
		maxSum = Integer.MIN_VALUE;
		dfs(root);
		return maxSum;
	}

	private int dfs(BinaryTreeNode node) {
		if (node == null)
			return 0;

		// Compute max path sum from left and right children
		int leftMax = Math.max(dfs(node.left), 0);
		int rightMax = Math.max(dfs(node.right), 0);

		// Update global max path sum with the possible split at this node
		maxSum = Math.max(maxSum, node.key + leftMax + rightMax);

		// Return max path sum ending at this node
		return node.key + Math.max(leftMax, rightMax);
	}

	public static void main(String[] args) {
		MaxPathSum ms = new MaxPathSum();
		ms.root = new BinaryTreeNode(4);
		ms.root.left = new BinaryTreeNode(7);
		ms.root.right = new BinaryTreeNode(9);
		System.out.println(ms.maxPathSum(ms.root));
	}
	/**
	 * We can solve this problem using a recursive depth-first search (DFS). At each
	 * node, we determine the maximum path sum that includes the node and
	 * potentially extends to its left or right child.
	 * 
	 * Here's an efficient approach: 1. Use recursion to explore left and right
	 * subtrees. 2. Compute the maximum path sum ending at the current node, either
	 * including one of its children or stopping at itself. 3. Track the maximum
	 * path sum seen so far. 4. Return the maximum gain from each subtree for
	 * further computation.
	 */
}
