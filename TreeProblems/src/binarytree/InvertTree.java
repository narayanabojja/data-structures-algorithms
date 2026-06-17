package binarytree;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * 
 * 
 */
public class InvertTree {

	BinaryTreeNode root;

	/**
	 * The time complexity of the `invertTree` method can be expressed as O(n),
	 * where n is the number of nodes in the binary tree. This is because the method
	 * traverses each node of the tree once. As for the space complexity, it's O(h),
	 * where h is the height of the binary tree. This is because the method utilizes
	 * recursion, and the maximum depth of the recursion stack is equal to the
	 * height of the binary tree.
	 * 
	 */
	public BinaryTreeNode invertTree(BinaryTreeNode root) {

		if (root == null) {
			return root;
		}
		invertTree(root.left);
		invertTree(root.right);
		BinaryTreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}

	public static void main(String[] args) {

		InvertTree bt = new InvertTree();
		bt.root = new BinaryTreeNode(4);
		bt.root.left = new BinaryTreeNode(7);
		bt.root.right = new BinaryTreeNode(9);
		bt.root.right.left = new BinaryTreeNode(10);
		bt.root.left.left = new BinaryTreeNode(5);
		bt.root.left.left.right = new BinaryTreeNode(6);
		bt.preOrder(bt.root);
		bt.invertTree(bt.root);
		System.out.println();
		bt.preOrder(bt.root);
	}

	public void preOrder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.key + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
}
