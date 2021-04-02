import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		ExpandableArray myArray = new ExpandableArray();
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("Welcome to the ExpandableArray testing program. Please make a selection:");
			System.out.println("1) Get Value");
			System.out.println("2) Set Value");
			System.out.println("3) Quit");
			System.out.println("");
			System.out.println("Selection: ");
			int selection = input.nextInt();
			
			if(selection == 1) {
				System.out.println("Enter an index number: ");
				int indexSelection = input.nextInt();
				System.out.println("The value at index " + indexSelection + " is: " + myArray.get(indexSelection));
				
			} else if (selection == 2) {
				System.out.println("Enter an index number: ");
				int indexSelection = input.nextInt();
				System.out.println("Enter a value: ");
				input.nextLine();
				String value = input.nextLine();
				myArray.set(indexSelection, value);
				System.out.println("Array updated.");
				
			} else {
				System.out.println("Quitting.");
				break;
			}
		}
	}
}
