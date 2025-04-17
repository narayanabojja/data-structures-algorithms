package bitmanipulation;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i
 * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * Time and Space Complexity Time Complexity: O(n) — Each number from 1 to n is
 * processed once.
 * 
 * Space Complexity: O(n) — We use an array of size n + 1 for the answer.
 */
public class CountingBits {

	public static void main(String[] args) {
		int n = 5;
		int[] result = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			// To get the count for i, just take the count for i / 2 and add 1 if i ends in
			// a 1.
			result[i] = result[i >> 1] + (i & 1);
		}
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
	/**
	 * i >> 1 is i divided by 2 (i.e., right shift by one bit).
	 * 
	 * ans[i >> 1] gives us the number of 1’s in the binary representation of i / 2.
	 * 
	 * (i & 1) is 1 if i is odd (last bit is 1), and 0 if even (last bit is 0).
	 * 
	 * So this recurrence builds on already computed results. Great point! Let’s go
	 * step-by-step through the **computation for `n = 5`**, this time including the
	 * values of `i >> 1` and `(i & 1)` for each `i`.
	 * 
	 * ---
	 * 
	 * ## 🔍 Example with Detailed Computation
	 * 
	 * We’ll compute `ans[i] = ans[i >> 1] + (i & 1)` for each `i` from `0` to `5`.
	 * 
	 * ### i = 0 - Binary: `000` - `i >> 1 = 0`, `(i & 1) = 0` - `ans[0] = ans[0] +
	 * 0 = 0 + 0 = 0`
	 * 
	 * ---
	 * 
	 * ### i = 1 - Binary: `001` - `i >> 1 = 0`, `(i & 1) = 1` - `ans[1] = ans[0] +
	 * 1 = 0 + 1 = 1`
	 * 
	 * ---
	 * 
	 * ### i = 2 - Binary: `010` - `i >> 1 = 1`, `(i & 1) = 0` - `ans[2] = ans[1] +
	 * 0 = 1 + 0 = 1`
	 * 
	 * ---
	 * 
	 * ### i = 3 - Binary: `011` - `i >> 1 = 1`, `(i & 1) = 1` - `ans[3] = ans[1] +
	 * 1 = 1 + 1 = 2`
	 * 
	 * ---
	 * 
	 * ### i = 4 - Binary: `100` - `i >> 1 = 2`, `(i & 1) = 0` - `ans[4] = ans[2] +
	 * 0 = 1 + 0 = 1`
	 * 
	 * ---
	 * 
	 * ### i = 5 - Binary: `101` - `i >> 1 = 2`, `(i & 1) = 1` - `ans[5] = ans[2] +
	 * 1 = 1 + 1 = 2`
	 * 
	 * ---
	 * 
	 * ## ✅ Final Output ``` ans = [0, 1, 1, 2, 1, 2] ```
	 * 
	 * ---
	 * 
	 * This step-by-step clearly shows how right shifting (`>>`) and bitwise AND
	 * (`&`) help us break the problem into smaller, already solved subproblems.
	 * 
	 * 
	 */
}
