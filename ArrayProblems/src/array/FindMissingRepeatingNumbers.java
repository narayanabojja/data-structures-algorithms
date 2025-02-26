package array;

/**
 * Time Complexity:O(n) due to the two for loops that iterate up to n. Space
 * Complexity:O(n) due to the extra hash array of size n+1.
 */
public class FindMissingRepeatingNumbers {
	// Function to find repeating and missing numbers
	public int[] findMissingRepeatingNumbers(int[] nums) {

		// Size of the array
		int n = nums.length;

		// Hash array to count occurrences
		int[] hash = new int[n + 1];

		// Update the hash array:
		for (int i = 0; i < n; i++) {
			hash[nums[i]]++;
		}

		int repeating = -1, missing = -1;

		// Find the repeating and missing number:
		for (int i = 1; i <= n; i++) {
			if (hash[i] == 2) {
				repeating = i;
			} else if (hash[i] == 0) {
				missing = i;
			}

			/*
			 * If both repeating and missing are found, break out of loop
			 */
			if (repeating != -1 && missing != -1) {
				break;
			}
		}

		// Return [repeating, missing]
		return new int[] { repeating, missing };
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 2, 5, 4, 6, 7, 5 };

		// Create an instance of Solution class
		FindMissingRepeatingNumbers sol = new FindMissingRepeatingNumbers();

		int[] result = sol.findMissingRepeatingNumbers(nums);

		// Print the repeating and missing numbers found
		System.out.println("The repeating and missing numbers are: {" + result[0] + ", " + result[1] + "}");
	}
}
