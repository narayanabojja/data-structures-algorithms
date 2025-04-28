package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a single string. The
 * encoded string is then decoded back to the original list of strings.
 * 
 * Time & Space Complexity Time complexity: O(m) for each e n c o d e ( )
 * encode() and decode() function calls. Space complexity: O(m+n) for each
 * encode() and decode() function calls. Where m is the sum of lengths of all
 * the strings and n is the number of strings.
 */
public class EncodeDecode {

	public static void main(String[] args) {
		List<String> string = List.of("neet", "code", "love", "you");
		EncodeDecode ed = new EncodeDecode();
		String endcoded = ed.encode(string);
		System.out.println(ed.decode(endcoded));
	}

	public String encode(List<String> string) {
		StringBuilder sb = new StringBuilder();
		for (String s : string) {
			sb.append(s.length()).append("#").append(s);
		}
		return sb.toString();
	}

	public List<String> decode(String str) {
		List<String> res = new ArrayList<>();
		int i = 0;
		while (i < str.length()) {
			int j = i + 1;
			while (str.charAt(j) != '#') {
				j++;
			}
			int length = Integer.parseInt(str.substring(i, j));
			i = j + 1;
			j = i + length;
			res.add(str.substring(i, j));
			i = j;
		}
		return res;

	}
}
