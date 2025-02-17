package array;

/**
 * Given an array arr[] of integers, you need to return the product of given
 * array elements except including the element itself.
 * https://takeuforward.org/arrays/product-of-array-except-itself/
 */
public class ProductArrayExceptSelf {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		arr = productExceptSelf(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		// Prefix array: Each element prefix[i] stores the product of all elements
		// before i.
		int[] prefix = new int[n];
		prefix[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			prefix[i] = prefix[i - 1] * nums[i - 1];
		}
		// Suffix array: Each element suffix[i] stores the product of all elements after
		// i.
		int[] suffix = new int[n];
		suffix[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1] * nums[i + 1];
		}
		for (int i = 0; i < n; i++) {
			nums[i] = prefix[i] * suffix[i];
		}
		return nums;
	}
}
