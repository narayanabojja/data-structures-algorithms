package maths;

public class LCM {

	public static void main(String[] args) {
		int n1 = 4;
		int n2 = 24;
		int gcd = GCD(n1, n2);
		System.out.println((n1 * n2) / gcd);

	}

	/**
	 * The optimal way to find LCM to two numbers is by finding their GCD and using
	 * the formula: lcm(n1, n2) = (n1 * n2) / gcd(n1, n2).
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static int GCD(int n1, int n2) {
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
