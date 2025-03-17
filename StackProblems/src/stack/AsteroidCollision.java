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
	/**
	 * Intuition: The first thing to understand is the condition for two asteroids
	 * to collide.
	 * 
	 * When does two asteroids collide? We know that when two asteroids are moving
	 * in opposite direction, they collide. Now, there can be two cases of opposite
	 * moving asteroids: Moving apart from each other. Moving towards each other.
	 * 
	 * It is clear that the collision will only happen in the second case, i.e.,
	 * when the asteroids are moving towards each other. This will happen when the
	 * first asteriod is moving towards right and later asteroid is moving towards
	 * left.
	 * 
	 * Now, in order to perform the collisions, only the left moving asteroids must
	 * be observed as all the earlier asteroids will be moving towards the right
	 * direction. For every left moving asteroid, we must first consider the
	 * asteroid that was found last moving towards the right (because it will be the
	 * asteroid undergoing collision first). This gives an idea of using Stack data
	 * structure because it stores elements in LIFO fashion.
	 * 
	 * Now there can three scenarios that can arise during the collision: The size
	 * of the right moving asteroid is more than the size of the left moving
	 * asteroid: In this case, the left moving asteroid will be destroyed leaving
	 * the right moving asteroird moving in the same direction. The size of the
	 * right moving asteroid is less than the size of the left moving asteroid: In
	 * this case, the right moving asteroid will be destroyed leaving the left
	 * moving asteroird moving in the same direction which may potentially collide
	 * with more asteroids. The sizes of the right moving asteroid and left moving
	 * asteroid are identical: In this case, both the asteroids will be destroyed
	 * leaving no asteroid from this collision.
	 * 
	 * Thus, all the right moving asteroids can be stored in the stack and for every
	 * right moving asteroid, collisions can be performed. Once the collision are
	 * done, any right or left moving asteroid will be left in the stack.
	 * Modification: Consider the following example: (img yet to be inserted) Here,
	 * once all the collisions happen, the answer is stored in the stack. But
	 * retrieving the elements from stack will return the elements in a reverse
	 * order. Hence, the elements must be reversed before returning the answer which
	 * takes extra time.
	 * 
	 * This can be avoided by implementing the stack using a list. Approach: Create
	 * a stack (using list implementation) to keep track of the asteroids that are
	 * still in motion after potential collisions. Loop through each asteroid in the
	 * input array. Handling right moving asteroids: If the current asteroid is
	 * moving to the right (positive value), push it onto the stack. Handling left
	 * moving asteroids: If the current asteroid is moving to the left (negative
	 * value), compare it with the asteroids on the stack. Continue to compare and
	 * remove right-moving asteroids (positive values) from the stack if they are
	 * smaller in size than the current left-moving asteroid. If an asteroid on the
	 * stack has the same size as the current left-moving asteroid, remove both
	 * asteroids. If the stack becomes empty or the top of the stack is a
	 * left-moving asteroid (negative value), there will be no collision happening
	 * with the current left-moving asteroid. Hence, push the current left-moving
	 * asteroid onto the stack. After processing all asteroids, the stack will
	 * contain the state of the asteroids after all collisions. Return this as the
	 * final result.
	 */
}
