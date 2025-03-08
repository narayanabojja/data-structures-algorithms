package array;

/**
 * Given an array of n elements. The task is to return the count of the number
 * of odd numbers in the array. Time Complexity:O(n) - The function iterates
 * through the array once, performing constant time operations for each element,
 * leading to a linear time complexity. Space Complexity:O(1) - The function
 * uses a fixed amount of extra space (an integer to store the count), resulting
 * in constant space complexity.
 */
public class CountOddInArray {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 7, 8, 9 };
		int oddValue = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				oddValue++;
			}
		}
		System.out.println(" Odd values count: " + oddValue);

	}

}
