package stack;

/**
 * A celebrity is a person who is known by everyone else at the party but does
 * not know anyone in return. Given a square matrix M of size N x N where
 * M[i][j] is 1 if person i knows person j, and 0 otherwise, determine if there
 * is a celebrity at the party. Return the index of the celebrity or -1 if no
 * such person exists. Note that M[i][i] is always 0.
 */
public class Celebrity {

	/**
	 * Time Complexity: O(N2) (where N is the size of square matrix)
	 * 
	 * Traversing the given square matrix to populate the two lists takes O(N2)
	 * time. Traversing on the lists to identify the celebrity takes O(N) time.
	 * Space Complexity: O(N) The two lists to store the count of how many people
	 * each person knows and how many people know each person takes O(N) space each.
	 * 
	 * @param M
	 * @return
	 */
	// Function to find the index of celebrity
	public int celebrityBruteForce(int[][] M) {

		// Size of given matrix
		int n = M.length;

		/*
		 * To store count of people who know person of index i
		 */
		int[] knowMe = new int[n];

		/*
		 * To store count of people who the person of index i knows
		 */
		int[] Iknow = new int[n];

		// Traverse on given matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				// If person i knows person j
				if (M[i][j] == 1) {
					knowMe[j]++;
					Iknow[i]++;
				}
			}
		}

		// Traverse for all persons to find the celebrity
		for (int i = 0; i < n; i++) {

			// Return the index of celebrity
			if (knowMe[i] == n - 1 && Iknow[i] == 0) {
				return i;
			}
		}

		// Return -1 if no celebrity is found
		return -1;
	}

	public static void main(String[] args) {
		int[][] M = { { 0, 1, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 1, 1, 0 } };

		/*
		 * Creating an instance of Solution class
		 */
		Celebrity sol = new Celebrity();

		// Function call to find the index of celebrity
		int ans = sol.celebrityBruteForce(M);
		int ansOptimal = sol.celebrityOptimal(M);
		System.out.println("The index of celebrity is: " + ans);
		System.out.println("The index of celebrity is (Optimal): " + ansOptimal);
	}

	/**
	 * Complexity Analysis: Time Complexity: O(N) (where N is the size of given
	 * square matrix)
	 * 
	 * Eliminating persons takes O(N) time. Checking if the last candidate is a
	 * celebrity takes O(N) time. Space Complexity: O(1) Using only a couple of
	 * variables.
	 * 
	 * @param M
	 * @return
	 */
	// Function to find the index of celebrity
	public int celebrityOptimal(int[][] M) {

		// Size of given matrix
		int n = M.length;

		// Top and Down pointers
		int top = 0, down = n - 1;

		// Traverse for all the people
		while (top < down) {

			/*
			 * If top knows down, it can not be a celebrity
			 */
			if (M[top][down] == 1) {
				top = top + 1;
			}

			/*
			 * If down knows top, it can not be a celebrity
			 */
			else if (M[down][top] == 1) {
				down = down - 1;
			}

			/*
			 * If both do not know each other, both cannot be the celebrity
			 */
			else {
				top++;
				down--;
			}
		}

		// Return -1 if no celebrity is found
		if (top > down)
			return -1;

		/*
		 * Check if the person pointed by top is celebrity
		 */
		for (int i = 0; i < n; i++) {
			if (i == top)
				continue;

			// Check if it is not a celebrity
			if (M[top][i] == 1 || M[i][top] == 0) {
				return -1;
			}
		}

		// Return the index of celebrity
		return top;
	}
	/**
	 * Intuition: Since there can be only one celebrity, instead of finding the
	 * celebrity, the people that are not celebrity can be determined. If all such
	 * people are found, any person left (if it exists) will be the celebrity. THe
	 * two conditions to identify the celebrity is:
	 * 
	 * The celebrity should be known by every person. There should be no person that
	 * celebrity knows. Approach: Set up two pointers, one at the top of the matrix
	 * and one at the bottom. Use the pointers to compare individuals: If the person
	 * at the top pointer knows the person at the bottom pointer, move the top
	 * pointer down (as it cannot be the celebrity). If the person at the bottom
	 * pointer knows the person at the top pointer, move the bottom pointer up (as
	 * it cannot be the celebrity). If neither knows the other, increment both
	 * pointers (as they both cannot be the celebrity). After the traversal, check
	 * if the remaining candidate pointed by the top pointer is a valid celebrity by
	 * ensuring that everyone knows this person and this person knows no one. If a
	 * valid celebrity is found, return the index; otherwise, return -1 indicating
	 * there is no celebrity.
	 */
}
