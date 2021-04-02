/*
 * File: Assignment4_a.java
 */

import acm.program.ConsoleProgram;

public class Assignment4_a extends ConsoleProgram{
	
	/**
	 * Constants:
	 */
	private static final long serialVersionUID = 1L; // Satisfies the IDE.

	/*
	 * run
	 * 
	 * This is the entry point for the program. Runs until
	 * the program window is closed. Will ask a user for a
	 * number which is put into a string. The string is
	 * passed into addCommasToNumericString and gets 
	 * printed with commas added to the decimal places.
	 * 
	 */
	public void run() {
		while(true) {
			String myString = readLine("Enter a number: ");
			if (myString.length() == 0) break;
			println(addCommasToNumericString(myString));
		}
		
	}
	
	/*
	 * addCommasToNumericString
	 * 
	 * This method adds commas to a given string of numbers.
	 * I start at the end of the string and begin working
	 * backwards. Every three decimal places, I add a comma.
	 * I just use a counter to keep track where to put a comma
	 * for simplicity.
	 * 
	 * Returns a string.
	 * 
	 */
	private String addCommasToNumericString(String digits) {
		String newString = "";
		int counter = 0;
		
		for(int i = digits.length() - 1; i >=0 ; i--) {
			
			if((counter % 3 == 0) && (counter != 0)){
				newString = "," + newString;
			}
			
			newString = digits.substring(i, i + 1) + newString;
			counter ++;
			
		}
		
		return newString;
	}

}
