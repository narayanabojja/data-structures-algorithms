package binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root node of a binary search tree (BST) and two node values p,q.
 * 
 * Return the lowest common ancestors(LCA) of the two nodes in BST.
 */
public class LcaBST {

	/**
	 * Time Complexity: O(H), where H is the height of the tree. As we are
	 * traversing till the height of the tree. In the best case, the time complexity
	 * is O(logN) for a balanced tree. In the worst case, the time complexity is
	 * O(N) for a skewed tree.
	 * 
	 * Space Complexity: O(H) because of the recursive stack space used for the
	 * function calls. In the worst case, the space complexity is O(N) for a skewed
	 * tree.
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	TreeNode lca(TreeNode root, int p, int q) {
		// base case
		if (root == null)
			return null;

		// Store the current node data
		int curr = root.data;

		// If both nodes are smaller than root
		if (curr < p && curr < q)
			// LCA lies in the right subtree
			return lca(root.right, p, q);

		// If both nodes are larger than root
		if (curr > p && curr > q)
			// LCA lies in the left subtree
			return lca(root.left, p, q);

		// Else root is the LCA
		return root;
	}

	public static void main(String[] args) {
		// Create a sample binary search tree
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(8);

		LcaBST sol = new LcaBST();

		// Find the LCA of nodes with values 5 and 8
		TreeNode ans = sol.lca(root, 5, 8);
		if (ans != null) {
			System.out.println("LCA(5, 8) = " + ans.data);
		} else {
			System.out.println("LCA(5, 8) is not present in the tree");
		}
		ans = sol.lcaBruteForce(root, 5, 8);

		if (ans != null) {
			System.out.println("LCA(5, 8) = " + ans.data);
		} else {
			System.out.println("LCA(5, 8) is not present in the tree");
		}

	}

	// Function to find the path from the root to a given node with value 'x'
	boolean getPath(TreeNode root, List<Integer> path, int x) {
		// Base case: If the current node is null, return false
		if (root == null) {
			return false;
		}

		// Add the current node's value to the path vector
		path.add(root.data);

		// If the current node's value is equal to the target value 'x', return true
		if (root.data == x) {
			return true;
		}

		// Recursively search for the target value 'x' in the left and right subtrees
		if (getPath(root.left, path, x) || getPath(root.right, path, x)) {
			return true;
		}

		// If the target value 'x' is not found in the current path, backtrack
		path.remove(path.size() - 1);
		return false;
	}

	/**
	 * Complexity Analysis Time Complexity O(N + log(2N)), where N is the number of
	 * nodes. Finding the root-to-node paths using DFS is O(N), and iterating
	 * through arrays is O(min(P1, P2)).
	 * 
	 * Space Complexity O(log2 N) due to storing root-to-node paths and the
	 * recursion stack during DFS. The height of the tree (log2(N)) determines the
	 * space required for arrays and the maximum depth of the recursion stack.
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lcaBruteForce(TreeNode root, int p, int q) {
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();

		// Find paths from the root to the given nodes
		if (!getPath(root, path1, p) || !getPath(root, path2, q)) {
			return null;
		}

		// Find the last common element in the paths
		int i = 0;
		while (i < path1.size() && i < path2.size() && path1.get(i).equals(path2.get(i))) {
			i++;
		}

		// The last common element is the LCA
		return new TreeNode(path1.get(i - 1));
	}

}
