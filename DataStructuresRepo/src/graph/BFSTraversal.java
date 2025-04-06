package graph;

import java.util.*;

public class BFSTraversal {
	
	private Map<Integer, List<Integer>> adjList; // Adjacency list with arbitrary node values

	public BFSTraversal() {
		this.adjList = new HashMap<>();
	}

	// Add a node (optional, in case we want to explicitly declare nodes)
	public void addNode(int node) {
		adjList.putIfAbsent(node, new ArrayList<>());
	}

	// Add an edge between two arbitrary nodes
	public void addEdge(int src, int dest) {
		adjList.putIfAbsent(src, new ArrayList<>());
		adjList.putIfAbsent(dest, new ArrayList<>()); // Ensure the destination exists
		adjList.get(src).add(dest); // Directed graph
	}

	// BFS Traversal for Arbitrary Node Values
	public void bfs(int startNode) {
		if (!adjList.containsKey(startNode)) {
			System.out.println("Start node not found in graph!");
			return;
		}

		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();

		visited.add(startNode);
		queue.add(startNode);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " "); // Process node

			for (int neighbor : adjList.get(node)) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					queue.add(neighbor);
				}
			}
		}
	}

	public static void main(String[] args) {
		BFSTraversal g = new BFSTraversal();

		g.addEdge(3, 5);
		g.addEdge(3, 7);
		g.addEdge(5, 10);
		g.addEdge(7, 10);
		g.addEdge(10, 12);

		System.out.println("BFS Traversal starting from node 3:");
		g.bfs(3);
	}
}
