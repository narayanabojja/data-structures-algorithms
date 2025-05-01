package heap;

import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value, and the median is the mean of the two
 * middle values.
 * 
 * For example, for arr = [2,3,4], the median is 3. For example, for arr =
 * [2,3], the median is (2 + 3) / 2 = 2.5. Implement the MedianFinder class:
 * 
 * MedianFinder() initializes the MedianFinder object. void addNum(int num) adds
 * the integer num from the data stream to the data structure. double
 * findMedian() returns the median of all elements so far. Answers within 10-5
 * of the actual answer will be accepted.
 */
class MedianFinder {
	private PriorityQueue<Integer> maxHeap; // Stores the smaller half
	private PriorityQueue<Integer> minHeap; // Stores the larger half

	public MedianFinder() {
		maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max Heap
		minHeap = new PriorityQueue<>(); // Min Heap
	}

	/**
	 * Time Complexity - addNum(): O(log n) (due to heap insertions) - findMedian():
	 * O(1) (just accessing the top elements)
	 * 
	 * Space Complexity - O(n) (since we store all numbers in two heaps)
	 * 
	 */
	public void addNum(int num) {
		if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
			maxHeap.offer(num);
		} else {
			minHeap.offer(num);
		}

		// Balance the heaps
		/**
		 * The heaps should either be equal in size or Max Heap should have at most one
		 * extra element. If heaps are equal, the median is the average of the tops of
		 * both heaps. If Max Heap is larger by 1, then the median is simply
		 * maxHeap.peek().
		 * 
		 */
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.offer(maxHeap.poll());
		} else if (minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}
}

public class MedianFromDataStream {

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(2);
		medianFinder.addNum(5);
		medianFinder.addNum(7);
		medianFinder.addNum(9);
		System.out.println(medianFinder.findMedian());
	}

}
