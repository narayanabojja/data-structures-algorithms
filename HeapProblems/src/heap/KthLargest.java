package heap;

import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the kth largest element
 * in the array.
 * 
 * Note that it is the kth largest element in the sorted order, not the kth
 * distinct element.
 * 
 * Can you solve it without sorting?
 * 
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * 
 * Time complexity: O(nlogk)
 * 
 * Space complexity: O(k)
 */
public class KthLargest {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			pq.offer(nums[i]);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		System.out.println("Kth largest element " + pq.peek());
	}

}
