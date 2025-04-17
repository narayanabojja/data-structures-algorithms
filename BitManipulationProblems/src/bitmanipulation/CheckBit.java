package bitmanipulation;

/**
 * check if the **i-th** bit of a given number is set (i.e., if it is `1`)
 * 
 */
public class CheckBit {

	public static void main(String[] args) {
		int number = 13;
		int i = 2;
		System.out.println((number & (1 << i)) == 1);

	}

}
