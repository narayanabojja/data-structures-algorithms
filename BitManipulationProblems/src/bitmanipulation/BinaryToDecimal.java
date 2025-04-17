package bitmanipulation;

import java.util.Scanner;

/**
 * Complexity Analysis: Time Complexity: O(n) Traversing every bit in the
 * string. Space Complexity: O(1) Couple of variables used.
 * 
 */
public class BinaryToDecimal {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Prompt user input
		System.out.print("Enter a binary number: ");
		String binary = scanner.nextLine();

		// Convert binary to decimal
		int decimal = 0;
		int power = 0; // To track the power of 2

		// Loop through the binary string from right to left
		for (int i = binary.length() - 1; i >= 0; i--) {
			char bit = binary.charAt(i);
			if (bit == '1') {
				decimal += Math.pow(2, power); // Add 2^power if the bit is 1
			} else if (bit != '0') {
				System.out.println("Invalid binary number. Please enter a valid one.");
				return; // Exit if the input is not binary
			}
			power++;
		}

		// Display the result
		System.out.println("Decimal representation: " + decimal);

		scanner.close();

	}

}
