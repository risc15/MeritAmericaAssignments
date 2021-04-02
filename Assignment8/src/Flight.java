
public class Flight {

	private String start;
	private String destination;
	
	public Flight(String start, String destination) {
		this.start = start;
		this.destination = destination;
		System.out.println("Flight object created.");
	}
	
	public String getStart() {
		return this.start;
	}
	
	public String getDestination() {
		return this.destination;
	}
	
	public String toString() {
		return start + " -> " + destination;
	}
}
