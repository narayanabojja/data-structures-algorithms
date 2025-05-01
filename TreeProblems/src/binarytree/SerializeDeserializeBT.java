package binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * 
 * ✅ Time & Space Complexity Time Complexity: Serialize: O(n) – visit each node
 * once.
 * 
 * Deserialize: O(n) – process each token to rebuild the tree.
 * 
 * Space Complexity: Serialize: O(n) – due to recursion and output string.
 * 
 * Deserialize: O(n) – for queue and recursive call stack.
 */
public class SerializeDeserializeBT {

	public static void main(String[] args) {
		// Build original tree: [1, 2, 3, null, null, 4, 5]
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		SerializeDeserializeBT sdt = new SerializeDeserializeBT();
		String serialize = sdt.serialize(root);
		TreeNode node = sdt.deserialize(serialize);
		System.out.println("Deserialized Tree Structure:");

		sdt.printTree(node);
	}

	private void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		printTree(root.left);
		printTree(root.right);
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.toString();
	}

	private void serializeHelper(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("null,");
			return;
		}
		sb.append(root.data).append(",");
		serializeHelper(root.left, sb);
		serializeHelper(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] nodes = data.split(",");
		Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
		return deserializeHelper(queue);
	}

	private TreeNode deserializeHelper(Queue<String> queue) {
		String val = queue.poll();
		if (val.equals("null")) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.parseInt(val));
		node.left = deserializeHelper(queue);
		node.right = deserializeHelper(queue);
		return node;
	}
}
