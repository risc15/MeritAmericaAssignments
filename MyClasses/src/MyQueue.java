import java.util.Deque;

public class MyQueue {
	
	// Class Attributes:
	
	private static Deque<Integer> queue;
	
	// Constructor:
	
	public MyQueue() {
	}
	
	// Methods:
	
	// Pushes to the end of the arraylist:
	public void enqueue(int value) {
		queue.addFirst(value);
	}
	
	// Pops the front of the queue:
	public int dequeue() {
		if (!queue.isEmpty()) {
			return queue.removeLast();
		} else {
			return -1;
		}
	}
	
	// Returns true or false if queue is empty or not:
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
