package string;

/**
 * Given two strings s and goal, return true if and only if s can become goal
 * after some number of shifts on s.
 * 
 * A shift on s consists of moving the leftmost character of s to the rightmost
 * position.
 * 
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 * 
 * Time Complexity O(N) , because checking for a substring in s + s is linear in
 * time.
 * 
 * Space Complexity O(N) for the space needed to store the concatenated string s
 * + s.
 */
public class RotateString {

	public static void main(String[] args) {

		String s = "abcde";
		String goal = "cdeab";
		if (s.length() != goal.length()) {
			System.out.println(false);
		}
		String doubleS = s + s;
		System.out.println(doubleS.contains(goal));
	}

}
