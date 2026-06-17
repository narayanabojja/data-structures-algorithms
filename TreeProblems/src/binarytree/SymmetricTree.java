package binarytree;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 * 
 */
public class SymmetricTree {
	BinaryTreeNode root;

	/**
	 * Every node in the tree gets compared exactly once with its mirror
	 * counterpart. 
	 * The time complexity : O(n) space complexity, it's O(h), where h is the height
	 * of the binary tree.
	 */
	public boolean isSymmetric(BinaryTreeNode root) {
		if (root == null) {
			return true;
		}
		return checkSymmetric(root.left, root.right);
	}

	boolean checkSymmetric(BinaryTreeNode left, BinaryTreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return (left.key == right.key) && checkSymmetric(left.left, right.right)
				&& checkSymmetric(left.right, right.left);
	}

	public static void main(String[] args) {
		SymmetricTree tree = new SymmetricTree();
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(2);
		tree.root.left.left = new BinaryTreeNode(3);
		tree.root.left.right = new BinaryTreeNode(4);
		tree.root.right.left = new BinaryTreeNode(4);
		tree.root.right.right = new BinaryTreeNode(3);
		boolean output = tree.isSymmetric(tree.root);
		if (output == true)
			System.out.println("Symmetric");
		else
			System.out.println("Not symmetric");

	}

}
