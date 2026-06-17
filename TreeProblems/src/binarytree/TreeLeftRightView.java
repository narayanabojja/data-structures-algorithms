package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLeftRightView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Function to print Right View
	public static void rightView(BinaryTreeNode root) {
		if (root == null)
			return;

		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			// Traverse all nodes at current level
			for (int i = 0; i < size; i++) {
				BinaryTreeNode node = queue.poll();

				// Print the last node at this level
				if (i == size - 1) {
					System.out.print(node.key + " ");
				}

				// Add children for next level
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
	}

	// Function to print left View
	public static void leftView(BinaryTreeNode root) {
		if (root == null)
			return;

		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			// Traverse all nodes at current level
			for (int i = 0; i < size; i++) {
				BinaryTreeNode node = queue.poll();

				// Print the first node at this level
				if (i == 00) {
					System.out.print(node.key + " ");
				}

				// Add children for next level
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
	}
}
