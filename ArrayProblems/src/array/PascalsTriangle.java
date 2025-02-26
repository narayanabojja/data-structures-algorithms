package array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/description/ Given an integer
 * numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * The problem requires us to generate Pascal’s Triangle up to a given number of
 * rows. Pascal’s Triangle follows a specific pattern: Time Complexity:The time
 * complexity is O(numRows^2) due to the nested loop structure where the outer
 * loop iterates 'numRows' times and the inner loop's iterations depend on the
 * row number, summing up to a quadratic relationship. Space Complexity:The
 * space complexity is O(numRows^2) because the space required to store the
 * Pascal's triangle grows quadratically with the number of rows.
 * 
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		PascalsTriangle pt = new PascalsTriangle();
		List<List<Integer>> list = pt.generate(5);

		for (List<Integer> list2 : list) {
			for (Integer list3 : list2) {
				System.out.print(list3 + " ");
			}
			System.out.println();
		}

	}

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> ans = new ArrayList<>();
		// The first row always contains [1]
		if (numRows >= 1) {
			List<Integer> a = new ArrayList<>();
			a.add(1);
			ans.add(a);
		}
		// The second row always contains [1,1].
		if (numRows >= 2) {
			List<Integer> b = new ArrayList<>();
			b.add(1);
			b.add(1);
			ans.add(b);
		}
		// Each inner element is the sum of the two elements directly above it.
		// The triangle grows row by row based on this rule.

		for (int i = 2; i < numRows; i++) {
			List<Integer> oldlist = ans.get(ans.size() - 1);
			List<Integer> newlist = new ArrayList<>(ans.size() + 1);
			newlist.add(1);
			for (int j = 1; j < oldlist.size(); j++) {
				newlist.add(oldlist.get(j - 1) + oldlist.get(j));
			}
			newlist.add(1);

			ans.add(newlist);
		}

		return ans;
	}
}
