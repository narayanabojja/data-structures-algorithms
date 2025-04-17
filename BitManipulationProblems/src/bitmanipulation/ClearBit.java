package bitmanipulation;

/**
 * To clear the i-th bit of a number, the bitwise AND operator can be used with
 * the complement of the bit mask.
 * 
 */
public class ClearBit {

	public static void main(String[] args) {
		int number = 13;
		int i = 2;
		System.out.println(number & ~(1 << i));
	}

}
