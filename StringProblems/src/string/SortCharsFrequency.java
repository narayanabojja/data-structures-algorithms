package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a string s. Return the array of unique characters, sorted by
 * highest to lowest occurring characters.
 * 
 * If two or more characters have same frequency then arrange them in alphabetic
 * order.
 * 
 * Time Complexity:O(n + k log k), where n is the length of the string and k is
 * a constant (26 in this case) for sorting. Space Complexity:O(k), where k is a
 * constant (26) for the Pair array.
 */
public class SortCharsFrequency {
	
	// Helper class to store frequency and character
	class Pair {
		int freq;
		char ch;

		Pair(int f, char c) {
			this.freq = f;
			this.ch = c;
		}
	}

	public static void main(String[] args) {
		SortCharsFrequency sf = new SortCharsFrequency();
		String s = "tree";
		List<Character> result = sf.frequencySort(s);
		System.out.println(result);
	}

	public List<Character> frequencySort(String s) {
		// Frequency array for characters 'a' to 'z'
		Pair[] freq = new Pair[26];
		for (int i = 0; i < 26; i++) {
			freq[i] = new Pair(0, (char) (i + 'a'));
		}

		// Count frequency of each character
		for (char ch : s.toCharArray()) {
			freq[ch - 'a'].freq++;
		}

		// Sort based on frequency (descending) and alphabetically (ascending)
		Arrays.sort(freq, (p1, p2) -> {
			if (p1.freq != p2.freq)
				return p2.freq - p1.freq;
			return p1.ch - p2.ch;
		});

		// Collect result
		List<Character> result = new ArrayList<>();
		for (Pair p : freq) {
			if (p.freq > 0)
				result.add(p.ch);
		}
		return result;
	}

}
