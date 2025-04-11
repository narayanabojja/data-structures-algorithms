package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * You need to implement the Max Heap with the following given methods.
 * 
 * insert (x) -> insert value x to the max heap getMax -> Output the maximum
 * value from the max heap exctractMax -> Remove the maximum element from the
 * heap heapSize -> return the current size of the heap isEmpty -> returns if
 * heap is empty or not changeKey (ind, val) -> update the value at given index
 * to val (index will be given 0-based indexing) initializeHeap -> Initialize
 * the heap
 */
public class MaxHeap {

	private List<Integer> arr; // list to store the max-heap
	private int count; // to store the count of elements in max-heap

	// Constructor
	public MaxHeap() {
		arr = new ArrayList<>();
		count = 0;
	}

	// Function to recursively heapify the array upwards
	private void heapifyUp(int ind) {
		int parentInd = (ind - 1) / 2;

		// If current index holds larger value than the parent
		if (ind > 0 && arr.get(ind) > arr.get(parentInd)) {
			// Swap the values at the two indices
			int temp = arr.get(ind);
			arr.set(ind, arr.get(parentInd));
			arr.set(parentInd, temp);

			// Recursively heapify the upper nodes
			heapifyUp(parentInd);
		}

		return;
	}

	// Function to recursively heapify the array downwards
	private void heapifyDown(int ind) {
		int n = arr.size(); // Size of the array

		// To store the index of largest element
		int largestInd = ind;

		// Indices of the left and right children
		int leftChildInd = 2 * ind + 1;
		int rightChildInd = 2 * ind + 2;

		// If the left child holds larger value, update the largest index
		if (leftChildInd < n && arr.get(leftChildInd) > arr.get(largestInd))
			largestInd = leftChildInd;

		// If the right child holds larger value, update the largest index
		if (rightChildInd < n && arr.get(rightChildInd) > arr.get(largestInd))
			largestInd = rightChildInd;

		// If the largest element index is updated
		if (largestInd != ind) {
			// Swap the largest element with the current index
			int temp = arr.get(largestInd);
			arr.set(largestInd, arr.get(ind));
			arr.set(ind, temp);

			// Recursively heapify the lower subtree
			heapifyDown(largestInd);
		}

		return;
	}

	// Method to intialize the max-heap data structure
	public void initializeHeap() {
		arr.clear();
		count = 0;
	}

	// Method to insert a given value in the max-heap
	public void insert(int key) {
		// Insert the value at the back of the list
		arr.add(key);

		// Heapify upwards
		heapifyUp(count);
		count = count + 1; // Increment the counter;

		return;
	}

	// Method to change the value at a given index in max-heap
	public void changeKey(int index, int new_val) {
		// If the current value is replaced with a larger value
		if (arr.get(index) < new_val) {
			arr.set(index, new_val);
			heapifyUp(index);
		}
		// Otherwise (if the current value is replaced with smaller value)
		else {
			arr.set(index, new_val);
			heapifyDown(index);
		}

		return;
	}

	// Method to extract the maximum value from the max-heap
	public void extractMax() {
		int ele = arr.get(0); // maximum value in the heap

		// Swap the top value with the value at last index
		int temp = arr.get(count - 1);
		arr.set(count - 1, ele);
		arr.set(0, temp);

		arr.remove(count - 1); // Pop the maximum value from the list
		count = count - 1; // Decrement the counter

		// Heapify the root value downwards
		if (count > 0) {
			heapifyDown(0);
		}
	}

	// Method to return if the max-heap is empty
	public boolean isEmpty() {
		return (count == 0);
	}

	// Method to return the maximum value in the max-heap
	public int getMax() {
		// Return the value stored at the root
		return arr.get(0);
	}

	// Method to return the size of max-heap
	public int heapSize() {
		return count;
	}

	public static void main(String[] args) {

		// Creating an object of the Solution class
		MaxHeap heap = new MaxHeap();

		// Initializing a max heap data structure
		heap.initializeHeap();

		// Performing different operations
		heap.insert(4);
		System.out.println("Inserting 4 in the max-heap");
		heap.insert(1);
		System.out.println("Inserting 1 in the max-heap");
		heap.insert(10);
		System.out.println("Inserting 10 in the max-heap");
		System.out.println("Maximum value in the heap is: " + heap.getMax());
		System.out.println("Size of max-heap is: " + heap.heapSize());
		System.out.println("Is heap empty: " + heap.isEmpty());
		System.out.println("Extracting maximum value from the heap");
		heap.extractMax();
		System.out.println("Changing value at index 0 to 16");
		heap.changeKey(0, 16);
		System.out.println("Maximum value in the heap is: " + heap.getMax());
	}
	/**
	 * Complexity Analysis: Considering there are maximum N elements inserted in the
	 * heap data structure,
	 * 
	 * Time Complexity:
	 * 
	 * Insert(val): Inserting and Heapifying upwards contribute to O(logN) time. Get
	 * Maximum(): Constant time operation, i.e., O(1). Extract Maximum(): Involves
	 * Heapifying downwards contributing to O(logN) time. Heap Size(): Constant time
	 * operation, i.e., O(1). Is Empty(): Constant time operation, i.e., O(1).
	 * Change Key(ind, val): Involves heapifying which takes O(logN) time.
	 * 
	 * Space Complexity: O(N), because of the array used to store the elements.
	 */

}
