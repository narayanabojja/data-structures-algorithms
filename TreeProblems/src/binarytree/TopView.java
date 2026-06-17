package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Given the root of a binary tree, return the top view of the binary tree. Top
 * view of a binary tree is the set of nodes visible when the tree is viewed
 * from the top. Return nodes from the leftmost node to the rightmost node. Also
 * if 2 nodes are outside the shadow of the tree and are at the same position
 * then consider the left ones only(i.e. leftmost).
 */

class Pair {
	BinaryTreeNode node;
	int hd;

	Pair(BinaryTreeNode node, int hd) {
		this.node = node;
		this.hd = hd;
	}
}

public class TopView {

	BinaryTreeNode root;

	public static void main(String[] args) {
		TopView tree = new TopView();
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(3);
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.left.right = new BinaryTreeNode(5);
		System.out.println(topView(tree.root));
	}

	public static List<Integer> topView(BinaryTreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		//HashMap also can be used. track minHD and maxHD during traversal.
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			BinaryTreeNode node = pair.node;
			int hd = pair.hd;
			if (!map.containsKey(hd)) {
				map.put(hd, node.key);
			}
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
