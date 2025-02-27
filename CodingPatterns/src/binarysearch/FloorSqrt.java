package binarysearch;

/**
 * Given a positive integer n. Find and return its square root. If n is not a
 * perfect square, then return the floor value of sqrt(n). Time Complexity:The
 * time complexity is O(log n) due to the binary search algorithm. Space
 * Complexity:The space complexity is O(1) as it uses a constant amount of extra
 * space.
 */
public class FloorSqrt {

	public static void main(String[] args) {

		System.out.println(floorSqrt(28));
	}

	public static long floorSqrt(long n) {
		long low = 1, high = n;

		// Binary search on the answer space
		while (low <= high) {
			long mid = (long) (low + high) / 2;
			long val = mid * mid;

			// Check if val is less than or equal to n
			if (val <= (long) (n)) {
				// Move to the right part
				low = (int) (mid + 1);
			} else {
				// Move to the left part
				high = (int) (mid - 1);
			}
		}

		// Return the floor of square root
		return high;
	}

}
