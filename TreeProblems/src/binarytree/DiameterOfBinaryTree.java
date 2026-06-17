package binarytree;

/**
 * Given the root of a binary tree, return the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path between
 * any two nodes in the tree. It may or may not pass through the root.
 * 
 * Time Complexity: O(N) In the optimized approach, each node is visited once,
 * and its height is calculated during the postorder traversal.
 * 
 * Space Complexity: O(H) The space complexity is determined by the maximum
 * depth of the recursion stack, which corresponds to the height of the tree.
 */
public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(4);
		root.left = new BinaryTreeNode(7);
		root.right = new BinaryTreeNode(9);
		root.right.left = new BinaryTreeNode(10);
		root.left.left = new BinaryTreeNode(5);
		root.left.left.right = new BinaryTreeNode(6);
		System.out.println(diameterOfBinaryTree(root));
	}

	public static int diameterOfBinaryTree(BinaryTreeNode root) {
		int[] diameter = new int[1];
		height(root, diameter);
		return diameter[0];
	}

	public static int height(BinaryTreeNode root, int[] diameter) {
		if (root == null) {
			return 0;
		}
		int lh = height(root.left, diameter);
		int rh = height(root.right, diameter);
		diameter[0] = Math.max(diameter[0], lh + rh);

		return 1 + Math.max(lh, rh);
	}
}
