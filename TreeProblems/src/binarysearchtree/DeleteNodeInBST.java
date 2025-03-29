package binarysearchtree;

/**
 * Given the root node of a binary search tree (BST) and a value key. Return the
 * root node of the BST after the deletion of the node with the given key value.
 * 
 * Time Complexity: O(H), explanation is that the time complexity is dependent
 * on the height of the tree.
 * 
 * Space Complexity: O(H), explanation is that the maximum depth of the
 * recursion call stack is equal to the height of the tree.
 */
public class DeleteNodeInBST {
	
	// Function to delete a node in a BST
	public TreeNode deleteNode(TreeNode root, int key) {
		// Check if the root is empty
		if (root == null) {
			// Return null if the root is empty
			return null;
		}

		// If the current root node has the key to be deleted
		if (root.data == key) {
			// Delete the node using the helper function
			return helper(root);
		}

		// Create a dummy node pointing to the root
		TreeNode dummy = root;

		// While loop to traverse the tree
		while (root != null) {
			// If the value to be deleted is in the left subtree
			if (root.data > key) {
				// If the left child exists and its value matches the key
				if (root.left != null && root.left.data == key) {
					// Delete the node using the helper function
					root.left = helper(root.left);
					break;
				} else {
					// If the value is not in the left subtree, move to the right subtree
					if (root.right != null && root.right.data == key) {
						// Delete the node using the helper function
						root.right = helper(root.right);
						break;
					} else {
						// Move to the right subtree
						root = root.right;
					}
				}
			}
		}
		// Return the modified tree
		return dummy;
	}

	// Helper function to delete the node
	public TreeNode helper(TreeNode root) {
		// If the left child of the root is null, return the right child
		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			// If the right child is null, return the left child
			return root.left;
		}

		// If both left and right children exist
		TreeNode rightChild = root.right; // Store the right child
		TreeNode lastRight = findLastRight(root.left); // Find the last right child of the left subtree
		lastRight.right = rightChild; // Set the right child of the last right node to the stored right child
		return root.left; // Return the left child as the new subtree
	}

	// Helper function to find the last right node in a subtree
	public TreeNode findLastRight(TreeNode root) {
		// Traverse to the rightmost node in the subtree
		if (root.right == null) {
			return root; // Return the rightmost node
		}
		return findLastRight(root.right); // Recursively find the last right node
	}

	public static void printInOrder(TreeNode root) {
		// Check if the current node is null (base case for recursion)
		if (root == null) {
			// If null, return and terminate the function
			return;
		}

		// Recursively call printInOrder for the left subtree
		printInOrder(root.left);

		// Print the value of the current node
		System.out.print(root.data + " ");

		// Recursively call printInOrder for the right subtree
		printInOrder(root.right);
	}

	public static void main(String[] args) {

		DeleteNodeInBST solution = new DeleteNodeInBST();

		// Creating a sample tree for testing purposes
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);

		// Printing the original tree
		System.out.print("Original Tree (Inorder Traversal): ");
		printInOrder(root);
		System.out.println();

		// Testing the deleteNode function
		int keyToDelete = 3;
		TreeNode updatedTree = solution.deleteNode(root, keyToDelete);

		// Printing the tree after deletion
		System.out.print("Tree After Deletion (Inorder Traversal): ");
		printInOrder(updatedTree);
		System.out.println();

	}

}
