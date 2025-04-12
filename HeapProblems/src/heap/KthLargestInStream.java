package heap;

import java.util.PriorityQueue;

/**
 * Implement a class KthLargest to find the kth largest number in a stream. It
 * should have the following methods:
 * 
 * KthLargest(int k, int [] nums) Initializes the object with the integer k and
 * the initial stream of numbers in nums int add(int val) Appends the integer
 * val to the stream and returns the kth largest element in the stream. Note
 * that it is the kth largest element in the sorted order, not the kth distinct
 * element.
 */
public class KthLargestInStream {
	PriorityQueue<Integer> minHeap;
	int k;

	public KthLargestInStream(int k, int[] nums) {
		this.k = k;
		minHeap = new PriorityQueue<>();
		for (int num : nums) {
			add(num);
		}
	}

	public int add(int val) {
		minHeap.offer(val);
		if (minHeap.size() > k) {
			minHeap.poll();
		}
		return minHeap.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		KthLargestInStream kthLargestInStream = new KthLargestInStream(3, nums);
		System.out.println(kthLargestInStream.add(5));
		System.out.println(kthLargestInStream.add(2));
		System.out.println(kthLargestInStream.add(7));
	}
	/**
	 * ### **Time Complexity** 1. **Constructor (`KthLargest`):** - The `for` loop
	 * iterates over all elements in the input array `nums` and calls the `add()`
	 * method for each element. - Each call to `add()` takes **O(log k)** time due
	 * to the insertion and potential removal operation in the **Min Heap**. - If
	 * `n` is the size of the initial array `nums`, the total time complexity for
	 * the constructor is **O(n * log k)**.
	 * 
	 * 2. **Adding an Element (`add` method):** - Insertion into the heap takes
	 * **O(log k)** time because the heap size is maintained at `k`. - Removing the
	 * smallest element (if the heap size exceeds `k`) also takes **O(log k)** time.
	 * - Thus, each call to `add()` is **O(log k)**.
	 ** 
	 * Overall Time Complexity:** - Constructor: **O(n * log k)**. - Adding a single
	 * element: **O(log k)**.
	 * 
	 * ---
	 * 
	 * ### **Space Complexity** - The **Min Heap** stores at most `k` elements,
	 * requiring **O(k)** space. - No additional space is used apart from the heap
	 * and a few variables.
	 ** 
	 * Overall Space Complexity:** - **O(k)**.
	 * 
	 * 
	 */
}
