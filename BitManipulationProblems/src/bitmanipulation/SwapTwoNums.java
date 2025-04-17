package bitmanipulation;

/**
 * Complexity Analysis: Time Complexity: O(1) Each XOR operation is constant
 * time. Space Complexity: O(1) No extra space used.
 */
public class SwapTwoNums {

	public static void main(String[] args) {
		int a = 7;
		int b = 9;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(" a = " + a + " b = " + b);

	}

}
