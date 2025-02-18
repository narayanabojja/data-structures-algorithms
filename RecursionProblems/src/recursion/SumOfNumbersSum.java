package recursion;

/**
 * Given an integer N, return the sum of first N natural numbers. Try to solve
 * this using recursion.
 * 
 * Time Complexity:The time complexity is O(N) because the function calls itself
 * N times before reaching the base case. Space Complexity:The space complexity
 * is O(N) due to the stack space used by the recursive calls
 * 
 */
public class SumOfNumbersSum {

	public static void main(String[] args) {
		SumOfNumbersSum sn = new SumOfNumbersSum();
		System.out.println(sn.NnumbersSum(5));
	}

	public int NnumbersSum(int N) {
		if (N == 1) {
			return 1;
		}
		return N + NnumbersSum(N - 1);
	}
}
