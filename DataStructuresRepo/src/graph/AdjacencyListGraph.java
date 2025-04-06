package graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Space Complexity: O(2xE) The space needed to represent a graph using its
 * adjacency matrix is N² locations. This representation is much better than the
 * adjacency matrix for sparse graphs (where the number of edges is less), as
 * matrix representation consumes n² locations, and most of them are unused.
 * 
 */
public class AdjacencyListGraph {

	public static void main(String[] args) {

		// Taking the input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// adjacency list for undirected graph
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n + 1);

		// Initialize the adjacency list
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		// Add the edges to the list
		for (int i = 0; i < m; i++) {
			// Taking the input
			int u = sc.nextInt();
			int v = sc.nextInt();

			// Adding the edges
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		sc.close();

	}

}
