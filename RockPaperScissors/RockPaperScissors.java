import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	public static void main(String[] args){
		intro();
		playing();
	}

	public static void intro(){
		System.out.println("Welcome to Rock, Paper, Scissors!");
		printDivider();
		
	}

	public static void playing(){
		Scanner input = new Scanner(System.in);			//Create a scanner object.
		Random randomNumber = new Random();			//Create a random number object.
		int computerSelectionNumber = randomNumber.nextInt(2);	//Generate a random number between 0 and 2.

		String computerSelection = "null";
		String playerSelection = "null";

		System.out.print("Please enter 0 for rock, 1 for paper, or 2 for scissors: ");
		int playerNumber = input.nextInt();

		if (playerNumber == 0){
			playerSelection = "rock";
		} else if (playerNumber == 1) {
			playerSelection = "paper";
		} else if (playerNumber == 2) {
			playerSelection = "scissors";
		} else {
			System.out.println("ERROR! Player selection invalid! Got: " + playerNumber);
			System.out.println("Try again!");
			playing();
		}

		if (computerSelectionNumber == 0){
			computerSelection = "rock";
		} else if (computerSelectionNumber == 1) {
			computerSelection = "paper";
		} else if (computerSelectionNumber == 2) {
			computerSelection = "scissors";
		} else {
			System.out.println("ERROR! Computer selection was invalid somehow! Got: " + computerSelectionNumber);
			computerSelection = "ERROR";
		}

		//if (computerSelectionNumber == playerNumber){
		//	System.out.print("DRAW! You and the computer selected " + playerSelection + "!");
		//} else if (playerNumber ==

		System.out.println("You selected: " + playerSelection);
		System.out.println("The computer selected: " + computerSelection);

	}

	public static void printDivider(){
		System.out.println("==========================================");
		System.out.println("");
	}
}
