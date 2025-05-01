package heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle values.
 * 
 * For examples, if arr = [2,3,4], the median is 3. For examples, if arr =
 * [1,2,3,4], the median is (2 + 3) / 2 = 2.5. You are given an integer array
 * nums and an integer k. There is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position.
 * 
 * Return the median array for each window in the original array. Answers within
 * 10-5 of the actual value will be accepted.
 * 
 */
class SlidingWindowMedian {
	private PriorityQueue<Integer> maxHeap; // Stores the smaller half
	private PriorityQueue<Integer> minHeap; // Stores the larger half
	private Map<Integer, Integer> countMap; // Tracks elements to be removed

	/**
	 * Time Complexity - addNum(): O(log k) (heap insertion) - removeNum(): O(log k)
	 * (lazy removal) - getMedian(): O(1) (accessing top elements) - Overall: O(n
	 * log k)
	 * 
	 * Space Complexity - O(k) (since we store k elements in heaps)
	 * 
	 * 
	 */
	public double[] medianSlidingWindow(int[] nums, int k) {
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
		countMap = new HashMap<>();
		double[] result = new double[nums.length - k + 1];

		for (int i = 0; i < nums.length; i++) {
			addNum(nums[i]);

			if (i >= k - 1) {
				result[i - k + 1] = getMedian();
				removeNum(nums[i - k + 1]);
			}
		}
		return result;
	}

	private void addNum(int num) {
		if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
			maxHeap.offer(num);
		} else {
			minHeap.offer(num);
		}
		balanceHeaps();
	}

	private void removeNum(int num) {
		countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		balanceHeaps();
	}

	private void balanceHeaps() {
		while (!maxHeap.isEmpty() && countMap.getOrDefault(maxHeap.peek(), 0) > 0) {
			countMap.put(maxHeap.peek(), countMap.get(maxHeap.peek()) - 1);
			maxHeap.poll();
		}
		while (!minHeap.isEmpty() && countMap.getOrDefault(minHeap.peek(), 0) > 0) {
			countMap.put(minHeap.peek(), countMap.get(minHeap.peek()) - 1);
			minHeap.poll();
		}

		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.offer(maxHeap.poll());
		} else if (minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}

	private double getMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}

	public static void main(String[] args) {
		SlidingWindowMedian medianFinder = new SlidingWindowMedian();
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		double[] res = medianFinder.medianSlidingWindow(nums, 3);
		for (double d : res) {
			System.out.print(d + " ");
		}
	}
}