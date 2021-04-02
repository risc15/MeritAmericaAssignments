import acm.program.ConsoleProgram;

public class Problem3 extends ConsoleProgram{
	
	private static int userInput;
	private static int largestValue;
	private static int secondLargest;
	
	/*
	 * run
	 * 
	 * The description in the println below sums up the program perfectly:
	 */
	public void run() {
		
		println("This program finds the two largest integers in a list. Enter values," +
				" one per line, using a 0 to signal the end of the list.");
		print("? ");
		
		while((userInput = readInt()) != 0) {
				
			if((userInput > secondLargest)) {
				secondLargest = userInput;
			}
				
			if((userInput > largestValue)) {
				secondLargest = largestValue;
				largestValue = userInput;
			}
				
			print("? ");
		}
			
		println("The largest value is: " + largestValue);
		println("The second largest is: " + secondLargest);
	}
}
