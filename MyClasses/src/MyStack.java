import java.util.ArrayList;
import java.util.Deque;

public class MyStack {
	
	// Class Attributes:
	
	private static Deque<Integer> stack;
	
	// Constructor:
	
	public MyStack() {
	}
	
	// Methods:
	
	// Push takes in an integer and places it on the top of the stack which is the end
	// of this list:
	public void push(int value) {
		stack.addFirst(value);
	}
	
	// Pop removes the last entry in the list and returns it.
	public int pop() {
		if (!stack.isEmpty()) {
			return stack.removeFirst();
		} else {
			return -1;
		}
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public ArrayList<Integer> returnList() {
		ArrayList<Integer> myList = (ArrayList<Integer>)stack;
		return myList;
	}
}
