package graph;

import java.util.*;

public class DFSTraversal {

	private Map<Integer, List<Integer>> adjList; // Adjacency list with arbitrary node values

	public DFSTraversal() {
		this.adjList = new HashMap<>();
	}

	// Add an edge between two arbitrary nodes
	public void addEdge(int src, int dest) {
		adjList.putIfAbsent(src, new ArrayList<>());
		adjList.putIfAbsent(dest, new ArrayList<>()); // Ensure the destination exists
		adjList.get(src).add(dest); // Directed graph
	}

	// DFS Traversal (Recursive)
	private void dfsRecursive(int node, Set<Integer> visited) {
		if (visited.contains(node))
			return;

		visited.add(node);
		System.out.print(node + " "); // Process node

		for (int neighbor : adjList.get(node)) {
			dfsRecursive(neighbor, visited);
		}
	}

	// Public method to start DFS
	/**
	 * Time & Space Complexity Time Complexity: O(V + E)
	 * 
	 * Space Complexity: O(V) (for stack and visited set)
	 * 
	 * @param startNode
	 */
	public void dfs(int startNode) {
		if (!adjList.containsKey(startNode)) {
			System.out.println("Start node not found in graph!");
			return;
		}
		Set<Integer> visited = new HashSet<>();
		dfsRecursive(startNode, visited);
	}

	public static void main(String[] args) {
		DFSTraversal g = new DFSTraversal();

		g.addEdge(3, 5);
		g.addEdge(3, 7);
		g.addEdge(5, 10);
		g.addEdge(7, 10);
		g.addEdge(10, 12);

		System.out.println("DFS Traversal starting from node 3:");
		g.dfs(3);
	}

	// Iterative DFS using Stack
	/**
	 * How It Works Use a stack to keep track of nodes.
	 * 
	 * Pop the top node, process it, and push its unvisited neighbors.
	 * 
	 * Push neighbors in reverse order (to ensure correct DFS order).
	 * 
	 * Repeat until the stack is empty.
	 * 
	 * Time & Space Complexity Time Complexity: O(V + E)
	 * 
	 * Space Complexity: O(V) (for stack and visited set)
	 * 
	 * @param startNode
	 */
	public void dfsIterative(int startNode) {
		
		if (!adjList.containsKey(startNode)) {
			System.out.println("Start node not found in graph!");
			return;
		}

		Set<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();

		stack.push(startNode);

		while (!stack.isEmpty()) {
			int node = stack.pop(); // Pop from stack
			if (!visited.contains(node)) {
				visited.add(node);
				System.out.print(node + " "); // Process node

				// Push neighbors in reverse order to maintain correct DFS order
				List<Integer> neighbors = adjList.get(node);
				Collections.reverse(neighbors);
				for (int neighbor : neighbors) {
					if (!visited.contains(neighbor)) {
						stack.push(neighbor);
					}
				}
			}
		}
	}
}
