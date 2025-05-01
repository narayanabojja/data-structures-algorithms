package binarytree;

/**
 * Given the roots of two binary trees root and subRoot, return true if there is
 * a subtree of root with the same structure and node values of subRoot and
 * false otherwise.
 * 
 * A subtree of a binary tree tree is a tree that consists of a node in tree and
 * all of this node's descendants. The tree tree could also be considered as a
 * subtree of itself.
 * 
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 * 
 */
public class IsSubtree {

	public static void main(String[] args) {
		// Create root tree: [3, 4, 5, 1, 2]
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);

		// Create subRoot tree: [4, 1, 2]
		TreeNode subRoot = new TreeNode(4);
		subRoot.left = new TreeNode(1);
		subRoot.right = new TreeNode(2);

		IsSubtree is = new IsSubtree();

		boolean result = is.isSubtree(root, subRoot);

		System.out.println("Is subRoot a subtree of root: " + result);
	}

	/**
	 * Time Complexity O(m * n) in the worst case, where:
	 * 
	 * n is the number of nodes in root
	 * 
	 * m is the number of nodes in subRoot
	 * 
	 * At each node in root, we potentially compare it with the entire subRoot.
	 * 
	 * Note: In practice, the average case is faster due to early mismatches.
	 * 
	 * Space Complexity O(h) where h is the height of the root tree — due to
	 * recursive stack space.
	 * 
	 * Worst case: O(n) for skewed trees.
	 * 
	 * Best case: O(log n) for balanced trees
	 * 
	 * @param root
	 * @param subRoot
	 * @return
	 */
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null)
			return false;
		if (isSameTree(root, subRoot))
			return true;
		// Recursively check left and right subtree
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	private boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		if (s == null || t == null)
			return false;
		if (s.data != t.data)
			return false;
		// Check left and right children
		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}
}
