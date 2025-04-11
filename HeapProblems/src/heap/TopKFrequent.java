package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequent {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		int[] result = topKFrequent(nums, k);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	/**
	 * Time Complexity: - Building the frequency map takes (O(N)), where (N) is the
	 * size of `nums`. - Each insertion/removal in the heap takes (O(log k)), and we
	 * do this for up to (N) elements. - Total time complexity: (O(N log k)). Space
	 * Complexity: - Frequency map requires (O(N)). - Min-heap requires (O(k)). -
	 * Overall space complexity: (O(N + k)).
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// Min-Heap: Keep track of the top k frequent elements
		PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			heap.add(entry);
			if (heap.size() > k) {
				heap.poll(); // Remove the least frequent element
			}
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = heap.poll().getKey();
		}

		return result;
	}
}
