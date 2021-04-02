/*
 * File: Assignment4_b.java
 */

import acm.program.ConsoleProgram;

public class Assignment4_b extends ConsoleProgram{

	/**
	 * Constants:
	 */
	private static final long serialVersionUID = 1L;	// Satisfies the IDE.

	/*
	 * run
	 * 
	 * This is the entry point of the program. This runs until the window is closed.
	 * The program reads a string from the user then asks for a single character
	 * to remove from the string.
	 */
	public void run() {
		while(true) {
			String myString = readLine("Enter a string: ");
			String stringToConvert = readLine("Enter a single character to remove from string: ");
			char myChar = stringToConvert.toCharArray()[0];
			println(removeAllOccurrences(myString, myChar));
		}
	}
	
	/*
	 * removeAllOccurrences
	 * 
	 * Loops through a for loop the size of the provided string and removes any
	 * characters that was given in the parameter.
	 * 
	 * Returns a string.
	 */
	public String removeAllOccurrences(String str, char ch) {
		String newString = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != ch) {
				newString += str.charAt(i);
			}
		}
		return newString;
	}
}