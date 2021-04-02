import java.util.Scanner;

public class Problem5 {

	/*
	 * Class variables:
	 */
	private static Scanner myScanner = new Scanner(System.in);
	private static String inputString;
	
	/*
	 * main
	 * 
	 * This program removes double letters from words.
	 */
	public static void main(String[] args) {
		System.out.print("Enter a string to remove double letters: ");
		inputString = myScanner.nextLine();
		System.out.println(removeDoubleLetters(inputString));
	}
	
	public static String removeDoubleLetters(String input) {
		String output = "";
		output += input.charAt(0);
		
		for(int i = 1; i < input.length(); i++) {
				if(input.charAt(i) != input.charAt(i - 1)) {
					output += input.charAt(i);
				}
		}
		
		return output;
	}
}
