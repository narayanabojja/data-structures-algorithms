package bitmanipulation;

import java.util.Scanner;

/**
 * Complexity Analysis: Time Complexity: O(logN) Since the number is divided by
 * 2 continuously. Space Complexity: O(logN) Storing the bits.
 */
public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Prompt user input
		System.out.print("Enter a decimal number: ");
		int decimal = scanner.nextInt();

		// Convert decimal to binary without built-in functions
		StringBuilder binary = new StringBuilder(); // To store binary digits

		while (decimal > 0) {
			int remainder = decimal % 2; // Find remainder when dividing by 2
			binary.insert(0, remainder); // Append remainder at the beginning
			decimal = decimal / 2; // Update decimal value
		}

		// If the number is 0, the binary representation is "0"
		if (binary.length() == 0) {
			binary.append("0");
		}

		// Display the result
		System.out.println("Binary representation: " + binary);

		scanner.close();
	}
}