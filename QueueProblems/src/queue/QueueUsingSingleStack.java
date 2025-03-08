package queue;

import java.util.Stack;

public class QueueUsingSingleStack {
	private Stack<Integer> stack = new Stack<>();

	// Enqueue operation. TC: O(1)
	public void enqueue(int value) {
		stack.push(value);
	}

	// Dequeue operation. TC: O(n)
	public int dequeue() throws Exception {
		
		if (stack.isEmpty()) {
			throw new Exception("Queue is empty");
		}

		// Pop the top element
		int top = stack.pop();

		// If the stack becomes empty after popping, return the element (base case)
		if (stack.isEmpty()) {
			return top;
		}

		// Recursively dequeue the next element
		int dequeuedValue = dequeue();

		// Push the popped element back to the stack to maintain order
		stack.push(top);

		return dequeuedValue;
	}

	// Peek operation (return the front element without removing it). TC: O(n)
	public int peek() throws Exception {
		if (stack.isEmpty()) {
			throw new Exception("Queue is empty");
		}

		// Pop the top element
		int top = stack.pop();

		// If the stack becomes empty after popping, return the element (base case)
		if (stack.isEmpty()) {
			stack.push(top); // Reinsert the element before returning
			return top;
		}

		// Recursively get the next element
		int frontValue = peek();

		// Push the popped element back to the stack to maintain order
		stack.push(top);

		return frontValue;
	}

	// Check if the queue is empty. TC: O(1)
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		try {
			QueueUsingSingleStack queue = new QueueUsingSingleStack();

			queue.enqueue(1);
			queue.enqueue(2);
			queue.enqueue(3);

			System.out.println("Front element: " + queue.peek()); // Output: 1
			System.out.println("dequeue: " + queue.dequeue()); // Output: 1
			System.out.println("Front element: " + queue.peek()); // Output: 2
			System.out.println(queue.dequeue()); // Output: 2
			System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false
			queue.enqueue(4);
			System.out.println("dequeue: " + queue.dequeue()); // Output: 3
			System.out.println("dequeue: " + queue.dequeue()); // Output: 4
			System.out.println("Is queue empty? " + queue.isEmpty()); // Output: true
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
