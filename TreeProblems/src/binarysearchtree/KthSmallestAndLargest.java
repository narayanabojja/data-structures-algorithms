package binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given the root node of a binary search tree (BST) and an integer k.
 *
 * Return the kth smallest and largest value (1-indexed) of all values of the
 * nodes in the tree.
 */
public class KthSmallestAndLargest {

	private int k;
	private int result;

	// Helper function to perform an in-order traversal of the BST
	private void inorderTraversal(TreeNode node, List<Integer> values) {
		if (node != null) {
			inorderTraversal(node.left, values);
			values.add(node.data);
			inorderTraversal(node.right, values);
		}
	}

	/**
	 * Time Complexity O(N log N), since the code performs an in-order traversal of
	 * the BST (O(N)) and then sorts the values (O(N log N)).
	 * 
	 * Space Complexity O(N), since the code stores all the node values in a list,
	 * where N is the number of nodes in the BST.
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public List<Integer> kLargesSmallBruteForce(TreeNode root, int k) {
		// List to store the node values
		List<Integer> values = new ArrayList<>();
		// Perform in-order traversal and collect values
		inorderTraversal(root, values);

		// Sort the values
		Collections.sort(values);

		// Find the kth smallest and kth largest values
		int kth_smallest = values.get(k - 1);
		int kth_largest = values.get(values.size() - k);

		List<Integer> result = new ArrayList<>();
		result.add(kth_smallest);
		result.add(kth_largest);

		return result;
	}

	// Main method to demonstrate the function
	public static void main(String[] args) {
		// Constructing the tree: [3, 1, 4, null, 2]
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);

		KthSmallestAndLargest solution = new KthSmallestAndLargest();
		int k = 1;
		List<Integer> result = solution.kLargesSmallBruteForce(root, k);

		System.out.println(result); // Output: [1, 4]
		result = solution.kLargesSmallOptimal(root, k);
		System.out.println(result);
	}

	// Function to find the kth smallest element
	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		this.result = -1;
		inorder(root);
		return result;
	}

	// Helper function for inorder traversal
	private void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			if (--k == 0) {
				result = node.data;
				return;
			}
			inorder(node.right);
		}
	}

	// Function to find the kth largest element
	public int kthLargest(TreeNode root, int k) {
		this.k = k;
		this.result = -1;
		reverseInorder(root);
		return result;
	}

	// Helper function for reverse inorder traversal
	private void reverseInorder(TreeNode node) {
		if (node != null) {
			reverseInorder(node.right);
			if (--k == 0) {
				result = node.data;
				return;
			}
			reverseInorder(node.left);
		}
	}

	/**
	 * Time Complexity O(N), where N is the number of nodes in the binary tree. The
	 * reason is that in the worst-case scenario, the inorder and reverse inorder
	 * traversals visit each node exactly once.
	 * 
	 * Space Complexity O(H), where H is the height of the binary tree.
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public List<Integer> kLargesSmallOptimal(TreeNode root, int k) {
		List<Integer> result = new ArrayList<>();
		result.add(kthSmallest(root, k));
		result.add(kthLargest(root, k));
		return result;
	}

}
