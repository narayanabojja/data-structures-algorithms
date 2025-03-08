package maths;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer n. You need to find all the divisors of n. Return
 * all the divisors of n as an array or list in a sorted order. A number which
 * completely divides another number is called it's divisor.
 * 
 * Time Complexity:O(n) due to the loop iterating up to n to find divisors and
 * another loop to convert List to array Space Complexity:O(d) where d is the
 * number of divisors of n, due to the ArrayList and resultant array storing the
 * divisors.
 */
public class Divisors {

	public static void main(String[] args) {
		
		int n = 10;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				list.add(i);
			}
		}
		System.out.println(list);
	}

}
