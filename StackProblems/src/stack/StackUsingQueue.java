package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * StackUsingQueue class implements a stack using two queues (FIFO data structures).
 * The stack supports standard operations: push, pop, peek, and isEmpty.
 * 
 * Methods:
 * - `push(int element)`: Pushes an element onto the stack.
 * - `pop()`: Removes and returns the top element of the stack.
 * - `peek()`: Retrieves the top element without removing it.
 * - `isEmpty()`: Checks if the stack is empty.
 */
public class StackUsingQueue {

    // Primary queue for holding elements
    private Queue<Integer> q1;

    // Auxiliary queue for reordering elements during pop/peek
    private Queue<Integer> q2;

    /**
     * Constructor to initialize the StackUsingQueue object.
     */
    public StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Pushes an element onto the stack.
     * 
     * @param element The element to push onto the stack.
     * 
     * Time Complexity: O(1) - Adding to a queue is constant time.
     * Space Complexity: O(1) - No additional space is used beyond storing the element.
     */
    public void push(int element) {
        q1.add(element);
    }

    /**
     * Removes and returns the top element of the stack.
     * 
     * @return The top element of the stack.
     * @throws IllegalStateException If the stack is empty.
     * 
     * Time Complexity: O(N) - Removing the top element requires transferring all but one element from q1 to q2.
     * Space Complexity: O(1) - Temporary queue swap does not use extra space.
     */
    public int pop() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // Retrieve the last element, which is the top of the stack
        int element = q1.remove();

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return element;
    }

    /**
     * Retrieves the top element of the stack without removing it.
     * 
     * @return The top element of the stack.
     * @throws IllegalStateException If the stack is empty.
     * 
     * Time Complexity: O(N) - Retrieving the top element requires transferring all but one element from q1 to q2.
     * Space Complexity: O(1) - Temporary queue swap does not use extra space.
     */
    public int peek() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // Retrieve the last element, which is the top of the stack
        int element = q1.peek();

        // Add the last element back to q2
        q2.add(q1.remove());

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return element;
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return True if the stack is empty, false otherwise.
     * 
     * Time Complexity: O(1) - Checking if a queue is empty is constant time.
     * Space Complexity: O(1) - No additional space is used.
     */
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    /**
     * Main method to demonstrate the functionality of StackUsingQueue.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.pop()); // Output: 2
        System.out.println(stack.pop()); // Output: 1

        System.out.println(stack.isEmpty()); // Output: true
    }
}
