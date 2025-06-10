package binarytree;

import java.util.HashMap;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same
 * tree, construct and return the binary tree.
 * 
 */
public class BuildTree {

	private HashMap<Integer, Integer> inorderMap;
	private int preorderIndex = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		inorderMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i); // Store index of each value in inorder
		}
		return constructTree(preorder, 0, inorder.length - 1);
	}

	private TreeNode constructTree(int[] preorder, int left, int right) {
		if (left > right)
			return null;

		int rootValue = preorder[preorderIndex++];
		TreeNode root = new TreeNode(rootValue);

		int inorderIndex = inorderMap.get(rootValue);

		root.left = constructTree(preorder, left, inorderIndex - 1);
		root.right = constructTree(preorder, inorderIndex + 1, right);

		return root;
	}

	public static void main(String[] args) {
		BuildTree bt = new BuildTree();
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode root = bt.buildTree(preorder, inorder);
		bt.preOrder(root);
	}

	public void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	/**
	 * If an interviewer asks how you derived the solution for **LeetCode 105
	 * (Construct Binary Tree from Preorder and Inorder Traversal)**, here's a
	 * structured way to explain your thought process:
	 * 
	 * ### **1. Understanding the Problem Statement** - We are given two arrays:
	 * **preorder** and **inorder** traversals of a binary tree. - We need to
	 * **reconstruct the original tree** using these two sequences.
	 * 
	 * ### **2. Key Observations** - **Preorder traversal** gives the **root
	 * first**, followed by left and right subtrees. - **Inorder traversal**
	 * provides a way to **split left and right subtrees** around the root.
	 * 
	 * ### **3. Strategy to Solve** - Use the **preorder array** to **determine the
	 * root node**. - Use the **inorder array** to **find the root’s position** and
	 * **split left and right subtrees**. - Recursively construct the tree.
	 * 
	 * ### **4. Optimizing with a HashMap** - Searching in `inorder[]` directly
	 * takes **O(n) time**, which is inefficient. - Instead, we precompute a **hash
	 * map** (`inorderMap`) for quick lookup (`O(1)` access).
	 * 
	 * ### **5. Deriving the Recursive Solution** - We maintain a **global
	 * `preorderIndex`** that progresses through the `preorder[]` array. - At each
	 * recursive step: - **Pick the next root** from `preorder[preorderIndex]`. -
	 * **Find its position** in `inorderMap`. - **Recursively build left and right
	 * subtrees** using sliced sections of the `inorder[]` array. - **Base case:**
	 * If `left > right`, return `null`.
	 * 
	 * ### **6. Time & Space Complexity** - **O(n) Time Complexity**: Since we visit
	 * every node once and lookup is O(1). - **O(n) Space Complexity**: Due to
	 * recursion and hashmap storage.
	 * 
	 * ### **How to Explain to an Interviewer** 1. **Start with problem
	 * understanding** (preorder → root first, inorder → defines structure). 2.
	 * **Explain key observations** (how inorder helps split subtrees). 3.
	 * **Highlight optimization using hashmap** (avoiding O(n) search). 4. **Walk
	 * through recursion logic step by step**. 5. **Discuss edge cases and
	 * complexity analysis**.
	 * 
	 * 
	 */
}
