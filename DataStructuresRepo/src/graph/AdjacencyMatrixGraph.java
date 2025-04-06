package graph;

import java.util.Scanner;

/**
 * Space Complexity: O(N2) The space needed to represent a graph using its
 * adjacency matrix is N² locations. It is a costly method as n² locations are
 * consumed. It is preferred for dense graphs where the number of edges is more.
 * 
 */
public class AdjacencyMatrixGraph {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] adj = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u][v] = 1;
			adj[v][u] = 1;
		}
		for (int[] is : adj) {
			for (int j : is) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
