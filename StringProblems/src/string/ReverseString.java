package string;

/**
 * Time Complexity: O(n) Space Complexity: O(n)
 */
public class ReverseString {

	public static void main(String[] args) {
		String word = "helloworld";
		System.out.println(word);
		char[] charArray = word.toCharArray();
		for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
			char temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;
		}
		String reverseWord = String.valueOf(charArray);
		System.out.println(reverseWord);
	}
	
}
