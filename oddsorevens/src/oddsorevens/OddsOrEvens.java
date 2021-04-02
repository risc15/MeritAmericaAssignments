package oddsorevens;
import java.util.*;
//import java.math.*;

public class OddsOrEvens {
	
	public static void main(String[] args) {
		
		String str1 = "Frodo Baggins";
		System.out.println(str1.toLowerCase().indexOf("B"));
		
		System.out.println("Let's play a game called \"Odds and Evens\"");
		
		Scanner input = new Scanner(System.in);
		System.out.print("What is your name? ");
		String name = input.nextLine();
		
		System.out.print("Hi " + name + ", which do you chose? (O)dds or (E)vens? ");
		String oddsOrEvens = input.nextLine();
		
		if (oddsOrEvens.equals("O")) {
			System.out.println(name + " has picked odds! The computer will be evens.");
		} else if (oddsOrEvens.equals("E")) {
			System.out.println(name + " has picked evens! The computer will be odds.");
		} else {
			System.out.println("\nError");
		}
		
		System.out.println("--------------------------------------------\n");
		
		System.out.print("How many \"fingers\" do you put out? ");
		int fingers = input.nextInt();
		
		Random rand = new Random();
		int computer = rand.nextInt(6);
		
		System.out.println("\nThe computer plays " + computer + " \"fingers\".");
		
		System.out.println("--------------------------------------------\n");
		
		int sum = fingers + computer;
		System.out.println(fingers + " + " + computer + " = " + sum);
		
		boolean oddOrEven = (sum & 1) == 0;
		System.out.print(sum + " is ...");
		if (oddOrEven) {
			System.out.println("even!");
			if (oddsOrEvens.equals("E")) {
				System.out.println("That means " + name + " wins!");
			} else {
				System.out.println("That means the computer wins!");
			}
		} else {
			System.out.println("odd!");
			if (oddsOrEvens.equals("O")) {
				System.out.println("That means " + name + " wins! :)");
			} else {
				System.out.println("That means the computer wins!");
			}
		}
		
		System.out.println("--------------------------------------------\n");
		
		input.close();
		
	}
	
	public static void myMethod(int x) {
		System.out.println(x + " was passed into this method.");
	}
	
	public static void myMethod(int x, int y) {
		System.out.println(x + " and " + y + " was passed into this method.");
	}
	
	public static void myMethod() {
		System.out.println("Nothing was passed into this method.");
	}
	
	public static void myMethod(String myString) {
		System.out.println(myString + " was passed into this method.");
	}
}
