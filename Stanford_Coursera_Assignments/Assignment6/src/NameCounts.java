// File: NameCounts.java

import acm.program.ConsoleProgram;
import java.util.HashMap;

public class NameCounts extends ConsoleProgram {

	/*
	 * Static variables:
	 */
	private static final long serialVersionUID = 1L;
	private static HashMap<String, Integer> countNames = new HashMap<String, Integer>();
	
	/*
	 * run
	 * 
	 * This program is centered around a hash map. The hash map contains a string and integer.
	 * 
	 * We start by reading input from the user. If the name is empty: "" then the program breaks
	 * out of the while loop. Otherwise, if the name put in to the hash map is not already in
	 * there, we add it with a count (int) of 1.
	 * 
	 * Lastly, if the name already exists, we increment the associated count with the matching
	 * name.
	 * 
	 * After the while loop is broken, we print out the hash map.
	 */
	public void run() {
		
		while(true) {
			String name = readLine("Enter name: ");
			
			if (name.equals("")) break;
			
			if (countNames.get(name) == null) {
				countNames.put(name, 1);
			} else {
				countNames.put(name,  countNames.get(name) +1);
			}
		}
		
		println("Loop broken.");
		for(String i : countNames.keySet()) {
			println("entry [" + i + "] has count " + countNames.get(i));
		}
	}
}
