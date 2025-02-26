package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of size n. Return all elements which appear more
 * than n/3 times in the array. The output can be returned in any order.
 *  Time
 * Complexity: O(N) + O(N), where N is size of the given array. The first O(N)
 * is to calculate the counts and find the expected majority elements. The
 * second one is to check if the calculated elements are the majority ones or
 * not.
 * 
 * Space Complexity: O(1) for only using a list that stores a maximum of 2
 * elements. The space used is so small that it can be considered constant
 */
public class MajorityElementTwo {
	// Function to find majority elements in an array
	public List<Integer> majorityElementTwo(int[] nums) {

		// Size of the array
		int n = nums.length;

		// Counts for elements el1 and el2
		int cnt1 = 0, cnt2 = 0;

		/*
		 * Initialize Element 1 and Element 2 with INT_MIN value
		 */
		int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

		/*
		 * Find the potential candidates using Boyer Moore's Voting Algorithm
		 */
		for (int i = 0; i < n; i++) {
			if (cnt1 == 0 && el2 != nums[i]) {
				cnt1 = 1;
				// Initialize el1 as nums[i]
				el1 = nums[i];
			} else if (cnt2 == 0 && el1 != nums[i]) {
				cnt2 = 1;
				// Initialize el2 as nums[i]
				el2 = nums[i];
			} else if (nums[i] == el1) {
				// Increment count for el1
				cnt1++;
			} else if (nums[i] == el2) {
				// Increment count for el2
				cnt2++;
			} else {
				// Decrement count for el1
				cnt1--;
				// Decrement count for el2
				cnt2--;
			}
		}

		// Validate the candidates by counting occurrences in nums:
		// Reset counts for el1 and el2
		cnt1 = 0;
		cnt2 = 0;

		for (int i = 0; i < n; i++) {
			if (nums[i] == el1) {
				// Count occurrences of el1
				cnt1++;
			}
			if (nums[i] == el2) {
				// Count occurrences of el2
				cnt2++;
			}
		}

		/*
		 * Determine the minimum count required for a majority element
		 */
		int mini = n / 3 + 1;

		// List of answers
		List<Integer> result = new ArrayList<>();

		/*
		 * Add elements to the result vector if they appear more than n/3 times
		 */
		if (cnt1 >= mini) {
			result.add(el1);
		}
		if (cnt2 >= mini && el1 != el2) {
			// Avoid adding duplicate if el1 == el2
			result.add(el2);
		}

		// Uncomment the following line if you want to sort the answer array
		// Collections.sort(result); // TC --> O(2*log2) ~ O(1);

		// return the majority elements
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 11, 33, 33, 11, 33, 11 };

		// Create an instance of Solution class
		MajorityElementTwo sol = new MajorityElementTwo();

		List<Integer> ans = sol.majorityElementTwo(arr);

		// Print the majority elements found
		System.out.print("The majority elements are: ");
		for (int it : ans) {
			System.out.print(it + " ");
		}
		System.out.println();
	}
}
