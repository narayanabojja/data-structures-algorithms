package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers asteroids, where each integer represents an
 * asteroid in a row, determine the state of the asteroids after all collisions.
 * In this array, the absolute value represents the size of the asteroid, and
 * the sign represents its direction (positive meaning right and negative
 * meaning left). All asteroids move at the same speed. When two asteroids meet,
 * the smaller one will explode. If they are the same size, both will explode.
 * Asteroids moving in the same direction will never meet.
 * 
 * 
 * Exam
 */
public class AsteroidCollision {

	public static void main(String[] args) {
		int[] nums = { 10, 20, -10 };
		int[] result = asteroidCollision(nums);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	/**
	 * Complexity Analysis: Time Complexity: O(N) (where N is the size of the
	 * asteroids array)
	 * 
	 * Traversing all the asteroids takes O(N) time. Handling collisions: For each
	 * asteroid in the array, we may push or pop it from the stack at most once. The
	 * while loop checks the top of the stack and can pop elements from it. In the
	 * worst case, every asteroid can be pushed and popped from the stack once
	 * taking overall O(N) time. Space Complexity: O(N) In the worst case, all
	 * asteroids will be stored in the stack if there are no collisions, leading to
	 * a space requirement of O(N).
	 * 
	 * @param asteroids
	 * @return
	 */
	public static int[] asteroidCollision(int[] asteroids) {
		// Size of the array
		int n = asteroids.length;

		// List implementation of stack
		List<Integer> st = new ArrayList<>();

		// Traverse all the asteroids
		for (int i = 0; i < n; i++) {

			/*
			 * Push the asteroid in stack if a right moving asteroid is seen
			 */
			if (asteroids[i] > 0) {
				st.add(asteroids[i]);
			}

			/*
			 * Else if the asteroid is moving left, perform the collisions
			 */
			else {

				/*
				 * Until the right moving asteroids are smaller in size, keep on destroying them
				 */
				while (!st.isEmpty() && st.get(st.size() - 1) > 0 && st.get(st.size() - 1) < Math.abs(asteroids[i])) {

					// Destroy the asteroid
					st.remove(st.size() - 1);
				}

				/*
				 * If there is right moving asteroid which is of same size
				 */
				if (!st.isEmpty() && st.get(st.size() - 1) == Math.abs(asteroids[i])) {

					// Destroy both the asteroids
					st.remove(st.size() - 1);
				}

				/*
				 * Otherwise, if there is no left moving asteroid, the right moving asteroid
				 * will not be destroyed
				 */
				else if (st.isEmpty() || st.get(st.size() - 1) < 0) {

					// Storing the array in final state
					st.add(asteroids[i]);
				}
			}
		}

		// Convert list to array
		int[] result = new int[st.size()];
		for (int i = 0; i < st.size(); i++) {
			result[i] = st.get(i);
		}

		// Return the final state of asteroids
		return result;
	}
}
