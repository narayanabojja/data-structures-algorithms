package string;

import java.util.HashMap;

/**
 * Given a String, find the length of longest substring without any repeating
 * character.
 * https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/
 * Time Complexity: O(n) Space Complexity: O(min(n, m)) `n` is the length of the
 * string. `m` is the size of the character set (e.g., O(26) for lowercase
 * English letters). At worst, all characters are unique, storing up to O(n)
 * space.
 */
public class LongestSubStringWORepeatingChar {

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println("Length of LongestSubStringWORepeatingChar " + lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		HashMap<Character, Integer> charIndexMap = new HashMap<>();
		int maxLength = 0;
		int left = 0;

		for (int right = 0; right < s.length(); right++) {
			char currentChar = s.charAt(right);

			// If the character is already in the map, move the left pointer
			// right after the previous occurrence of the current character
			if (charIndexMap.containsKey(currentChar)) {
				left = Math.max(left, charIndexMap.get(currentChar) + 1);
			}

			// Update the map with the current character's latest index
			charIndexMap.put(currentChar, right);

			// Calculate the length of the current substring
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}
	/**
	 * Let's break down the time and space complexity of your
	 * `lengthOfLongestSubstring` method:
	 * 
	 * ### **Time Complexity**: 1. The method iterates over the string **once**
	 * using a single loop (`for` loop), so the **worst-case runtime is O(n)** where
	 * `n` is the length of the string. 2. The
	 * `charIndexMap.containsKey(currentChar)` and `charIndexMap.get(currentChar)`
	 * operations take **O(1)** on average (since HashMap provides constant-time
	 * lookups). 3. The `charIndexMap.put(currentChar, right)` operation also takes
	 * **O(1)** on average. 4. The `Math.max(left, charIndexMap.get(currentChar) +
	 * 1)` operation runs in **O(1)** time.
	 * 
	 * Since all operations inside the loop run in **O(1)** time, the overall time
	 * complexity is **O(n)**.
	 * 
	 * ### **Space Complexity**: 1. The method uses a **HashMap<Character,
	 * Integer>** to store character indices. In the worst case (when all characters
	 * in the string are unique), the HashMap stores `n` characters, requiring
	 * **O(n) space**. 2. Other variables (`maxLength`, `left`, `right`,
	 * `currentChar`) take **O(1)** space.
	 * 
	 * Thus, the total space complexity is **O(n)** due to the HashMap.
	 * 
	 * ### **Summary**: - **Time Complexity:** **O(n)** - **Space Complexity:**
	 * **O(n)**
	 * 
	 * Your approach efficiently finds the longest substring without repeating
	 * characters using a **Sliding Window + HashMap** technique.
	 * 
	 * 
	 */
}
