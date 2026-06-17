package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Given root of binary tree, return the bottom view of the binary tree. The
 * bottom view of a binary tree is the set of nodes visible when the tree is
 * viewed from the bottom. Return nodes from the leftmost node to the rightmost
 * node. Also if 2 nodes are outside the shadow of the tree and are at the same
 * position then consider the node that appears later in level traversal. Time
 * Complexity: O(N*logN) Space Complexity: O(N)
 */
public class BottomView {

	BinaryTreeNode root;

	public static void main(String[] args) {
		BottomView tree = new BottomView();
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(3);
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.left.right = new BinaryTreeNode(5);
		System.out.println(bottomView(tree.root));
	}

	public static List<Integer> bottomView(BinaryTreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		// HashMap also can be used. track minHD and maxHD during traversal.
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			BinaryTreeNode node = pair.node;
			int hd = pair.hd;
			map.put(hd, node.key);
			if (node.left != null) {
				queue.add(new Pair(node.left, hd - 1));
			}
			if (node.right != null) {
				queue.add(new Pair(node.right, hd + 1));
			}
		}
		for (Integer value : map.values()) {
			result.add(value);
		}
		return result;
	}

}
