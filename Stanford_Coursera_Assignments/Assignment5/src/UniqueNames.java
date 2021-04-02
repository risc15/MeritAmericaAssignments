import java.util.Scanner;
import java.util.ArrayList;

public class UniqueNames {
	
	static Scanner userInput = new Scanner(System.in);
	static ArrayList<String> nameList = new ArrayList<String>();
	static boolean isDuplicate;
	static boolean running = true;
	
	
	/*
	 * main
	 * 
	 * This runs as long as the input name is not empty.
	 * 
	 * As we input new names, we loop through the nameList array. If a duplicate
	 * name is found, we set a flag to true.
	 * 
	 * Outside the for loop, we check if a flag was set. If a duplicate name was
	 * found, the new name is not added.
	 * 
	 * The flag is reset and we keep going until the user is done with names.
	 */
	public static void main(String[] args) {
		
		while(running) {
			System.out.println("Enter name: ");
			String name = userInput.nextLine();
			
			if (name.equals("")) {
				running = false;
			} else {
				if(!(nameList.contains(name))) {
					nameList.add(name);
				}
			}
		}
		// Print results:
		System.out.println(nameList);
	}
		
}

/*
 * 				isDuplicate = false;
				for (int i = 0; i < nameList.size(); i++) {
					
					if (nameList.get(i).equals(name)) {
						isDuplicate = true;
					}
				}
					
				if (!isDuplicate) {
					nameList.add(name);
				}
 */
