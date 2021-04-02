
public class HackerRankStorage {

	class Result {

	    /*
	     * Complete the 'applyOperations' function below.
	     *
	     * The function is expected to return an INTEGER_ARRAY.
	     * The function accepts INTEGER_ARRAY arr as parameter.
	     */

	    public static List<Integer> applyOperations(List<Integer> arr) {
	        // +==========================================================================================+
	        // | Step 1: If the stack is populated, pop all elements and push to the queue.               |
	        // | Step 2: Push the current array element from arr to the top of stack.                     |
	        // | Step 3: Pop each element from the queue, one by one, and push them to the top of stack.  |
	        // | After arr is empty, the stack will be returned.                                          |
	        // +==========================================================================================+
	        
	        MyStack stack = new MyStack();
	        MyQueue queue = new MyQueue();
	        //Queue<Integer> queue = new PriorityQueue<>();
	        //Stack<Integer> stack = new Stack<>();
	        
	        // This runs as long as arr is not empty:
	        while(!arr.isEmpty()){
	            
	            // Step 1:
	            while(!stack.isEmpty()){
	                try {
	                    queue.push(stack.pop());
	                } catch(IsEmptyException e) {
	                    
	                }
	            }
	            
	            // Step 2:
	            stack.push(arr.remove(0));
	            
	            // Step 3:
	            while(!queue.isEmpty()){
	                try {
	                    stack.push(queue.pop()); 
	                } catch(IsEmptyException e) {
	                    
	                }
	                
	            }
	        }
	        
	        // Return the contents of stack:
	        return stack.getStack();
	    }
	}

	// ========================================================================

	class MyStack {
	    
	    // Class Attributes:
	    
	    private List<Integer> stack;
	    
	    // Constructor:
	    
	    public MyStack() {
	        this.stack = new LinkedList<>();
	    }
	    
	    // Methods:
	    
	    // Push takes in an integer and places it on the top of the stack which is the front
	    // of this list:
	    public void push(int pushValue) {
	        this.stack.add(0,pushValue);
	    }
	    
	    // Pop removes the first entry in the list and returns it.
	    public int pop() throws IsEmptyException{
	        
	        try {
	            return this.stack.remove(0);
	        } catch(Exception e) {
	            throw new IsEmptyException("Error: stack is empty!");
	        }
	    }
	    
	    public List<Integer> getStack(){
	        return this.stack;
	    }
	    
	    public boolean isEmpty() {
	        return this.stack.isEmpty();
	    }
	}

	// ========================================================================

	class MyQueue {
	    
	    // Class Attributes:
	    
	    private List<Integer> queue;
	    
	    // Constructor:
	    
	    public MyQueue() {
	        this.queue = new LinkedList<Integer>();
	    }
	    
	    // Methods:
	    
	    // Pushes to the end of the arraylist:
	    public void push(int pushedValue) {
	        this.queue.add(pushedValue);
	    }
	    
	    // Pops the front of the queue:
	    public int pop() throws IsEmptyException{
	        if (this.queue.isEmpty()) {
	            throw new IsEmptyException("Error: queue is empty!");
	        } else {
	            return this.queue.remove(0);
	        }
	    }
	    
	    public List<Integer> getQueue(){
	        return this.queue;
	    }
	    
	    public boolean isEmpty() {
	        return this.queue.isEmpty();
	    }
	}

	// ========================================================================

	class IsEmptyException extends Exception{
	    
	    public IsEmptyException(String errorMessage){
	        super(errorMessage);
	    }
	}
}
