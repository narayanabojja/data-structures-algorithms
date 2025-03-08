package maths;

/**
 * Euclid's algorithm Time Complexity: O(log(min(num1, num2))) and Space
 * Complexity: O(log(min(num1, num2)))
 * 
 */
public class GCD {

	public static void main(String[] args) {
		System.out.println(gcd(6, 4));
	}

	static int gcd(int num1, int num2) {
		if (num2 == 0) {
			return num1;
		}
		return gcd(num2, num1 % num2);
	}

	/**
	 * Time Complexity:The time complexity is O(min(n1, n2)) because the loop runs
	 * from 1 to the minimum of n1 and n2. Space Complexity:The space complexity is
	 * O(1) because no additional space is used that scales with input size.
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public int GCDGeneral(int n1, int n2) {
		int minValue = Math.min(n1, n2);
		int gcd = 0;
		for (int i = 1; i <= minValue; i++) {
			if (n1 % i == 0 && (n2 % i == 0)) {
				gcd = Math.max(gcd, i);
			}
		}
		return gcd;
	}
}
