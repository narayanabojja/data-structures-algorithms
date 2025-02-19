package recursion;

/**
 * Given an integer num, return true if it is prime otherwise false. A prime
 * number is a number that is divisible only by 1 and itself. Time
 * Complexity:The time complexity is O(n), where n is the input number, as the
 * recursive function increments i until it equals n. Space Complexity:The space
 * complexity is O(n), due to the recursive call stack that grows linearly with
 * the input number n.
 */
public class CheckPrime {

	public static void main(String[] args) {
		CheckPrime cp = new CheckPrime();
		System.out.println(cp.checkPrime(5));
	}

	public boolean checkPrime(int num) {
		return isPrime(num, 2);
	}

	boolean isPrime(int num, int i) {
		if (i == num) {
			return true;
		} else if (i != num && num % i == 0) {
			return false;
		}
		return isPrime(num, i + 1);
	}
}
