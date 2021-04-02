import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Request
 * 
 * Creates a Request object.
 */
class Request {
	
	/*
	 * Instance variables:
	 */
	public int arrival_time;
    public int process_time;
	
    public Request(int arrival_time, int process_time) {
        this.arrival_time = arrival_time;
        this.process_time = process_time;
    }
}

/*
 * Response
 * 
 * Creates a Response object.
 * 
 * 
 */
class Response {
	
	/*
	 * Instance variables:
	 */
	public boolean dropped;
    public int start_time;
	
    public Response(boolean dropped, int start_time) {
        this.dropped = dropped;
        this.start_time = start_time;
    }

}


/*
 * Buffer
 * 
 * Creates a Buffer object.
 * 
 * We have a buffer size and an array list of finish times.
 * 
 */
class Buffer {
	
	/*
	 * Instance variables:
	 */
	private int bufferSize;
    private Queue<Integer> q; // This contains finish times.
    private int time;
	
    /*
     * Constructor:
     */
    public Buffer(int size) {
        this.bufferSize = size;
        this.q = new LinkedList<Integer>();
        this.time = 0;
    }

    /*
     * Process
     * 
     * This method takes in a Request object and outputs a new Response object.
     * 
     * 
     */
    public Response Process(Request request) {
        // write your code here
    	
    	// First, store the time the computer will finish processing the packet:
    	
    	if(this.q.size() <= this.bufferSize) {
    		this.q.add(request.process_time);
    	}
    	
    	// Next, pop from the front of the finish time queue (q) if its processing time 
    	
    	while(this.q.peek() <= this.time) {
    		this.q.remove();
    		
    	}
    	
    	/*
    	 *  If the queue is empty AND the packet arrival time is greater than or equal to the current time,
    	 *  we can immediately process the packet.
    	 *  
    	 *  If the request arrival time is greater than the current time, add to buffer for processing later.
    	 *  
    	 *  If the queue is not empty, check the first packet (finish time) and see if it matches the current
    	 *  time. If they are equal, make new response, increment the time, remove the entry from the queue, 
    	 *  then return the new response. If they are not equal, increment the time.
    	 */
    	
    	if (this.q.isEmpty() && request.arrival_time == this.time) {
    		Response newResponse = new Response(true, time);
    		this.time++;
    		return newResponse;
    		
    	} else if (this.q.isEmpty() && request.arrival_time > this.time){
    		this.q.add(request.process_time);
    		
    	} else if (!this.q.isEmpty()) {
    		if (this.q.peek() == time) {
    			Response newResponse = new Response(true, time);
    			this.time++;
    			this.q.remove();
    			return newResponse;
    		} else {
    			this.time++;
    		}
    		
    	}
		return null;
        
    }

}


class process_packages {
	
    /*
     * Main
     * 
     * Starting point. Creates a scanner and reads the buffer size. Then a new
     * buffer is created with the max size as an argument.
     * 
     * Two array lists are created, one that holds requests and the other responses.
     * 
     * Finally, the PrintResponses method is called.
     * 
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Buffer max size: ");
        int buffer_max_size = scanner.nextInt();
        Buffer buffer = new Buffer(buffer_max_size);

        ArrayList<Request> requests = ReadQueries(scanner);
        ArrayList<Response> responses = ProcessRequests(requests, buffer);
        PrintResponses(responses);
    }
	
	/*
	 * ReadQueries
	 * 
	 * This method takes in a scanner and outputs an array list containing requests.
	 * 
	 * The scanner reads the next int for a request count then an array list is set up
	 * to hold the Request objects.
	 * 
	 * In the for loop (request count), we read the arrival and process time, then create
	 * a new request object with the arrival and process times as arguments. The new
	 * Request is immediately added to the requests array created above.
	 * 
	 * Last, the array list is returned.
	 * 
	 */
    private static ArrayList<Request> ReadQueries(Scanner scanner) throws IOException {
    	System.out.println("Request count: ");
        int requests_count = scanner.nextInt();
        ArrayList<Request> requests = new ArrayList<Request>();
        for (int i = 0; i < requests_count; ++i) {
        	System.out.println("Arrival time: ");
            int arrival_time = scanner.nextInt();
            System.out.println("Process time: ");
            int process_time = scanner.nextInt();
            requests.add(new Request(arrival_time, process_time));
        }
        return requests;
    }

    
    /*
     * ProcessRequests
     * 
     * This method takes in an array list and a buffer and outputs an
     * array list of Response objects.
     * 
     * We start by creating a new array list of responses.
     * 
     * In a for loop that runs for each item in the input Request array list, we
     * process what's in the buffer , getting the requests, and add it to the 
     * newly created responses array list.
     * 
     * Finally, the responses array list is returned.
     */
    private static ArrayList<Response> ProcessRequests(ArrayList<Request> requests, Buffer buffer) {
        ArrayList<Response> responses = new ArrayList<Response>();
        for (int i = 0; i < requests.size(); ++i) {
            responses.add(buffer.Process(requests.get(i)));
        }
        return responses;
    }

    /*
     * PrintResponses
     * 
     * This takes in an array list of responses and prints whether or not a
     * response in the list was dropped. If it was not dropped, it outputs
     * the response's start time.
     * 
     * In the for loop that runs while i is less than the response array list size, 
     * we create a Response object and set it to point to the first one in the array.
     * 
     * Then, we check if the response was dropped. The result is printed.
     */
    private static void PrintResponses(ArrayList<Response> responses) {
        for (int i = 0; i < responses.size(); ++i) {
            Response response = responses.get(i);
            if (response.dropped) {
                System.out.println(-1);
            } else {
                System.out.println(response.start_time);
            }
        }
    }
}
