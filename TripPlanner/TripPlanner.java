import java.util.Scanner;

public class TripPlanner {
	public static void main(String[] args){
		//greeting();
		//travelTimeAndBudget();
		//timeDifference();
		countryArea();
		//howFar();
	}

	/*
	 * This method greets the user.
	*/
	public static void greeting(){
		System.out.println("			Welcome to Vacation Planner v1!");
		printDivider();
		Scanner input = new Scanner(System.in);		//Make the scanner to get input from console.
		System.out.print("What is your name? ");	//Not using println so the input is on the same line.
		String userName = input.nextLine();		//Use input.nextLine to get a whole line of input.
		System.out.print("\nNice to meet you " + userName +", where are you travelling to? ");
		String destination = input.nextLine();		//Use input.nextLine again to get the destination.
		System.out.println("\n" + destination + "? Sounds great! Let's get some more information...");
		printDivider();
	}

	public static void travelTimeAndBudget(){
		Scanner input = new Scanner(System.in);
		System.out.print("How many days are you going to spend travelling? ");
		int totalDays = input.nextInt();
		System.out.print("\nHow much money, in USD, are you planning to spend on your trip? ");
		double budget = input.nextDouble();
		System.out.print("\nWhat is the three letter currency symbol for your travel destination? ");
		String symbol = input.next();
		System.out.print("\nHow many " + symbol + " are there in 1 USD? ");
		double exchangeRate = input.nextDouble();

		System.out.println("\nIf you are travelling for " + totalDays + " days, that is the same as " + totalDays * 24 + " hours or " + totalDays * 1440 + " minutes.");

		double roundBudget = budget / totalDays * 100;
		double roundedBudget = ((int)roundBudget / 100.00);


		System.out.println("If you are going to spend $" + budget + " USD that means per day you can spend up to $" + roundedBudget + " USD.");

		double roundForeignBudgetTotalDays = ((exchangeRate * budget) / totalDays) * 100;
		double roundedForeignBudgetTotalDays = ((int)roundForeignBudgetTotalDays / 100.00);
		double roundForeignBudget = (exchangeRate * budget) * 100;
		double roundedForeignBudget = ((int)roundForeignBudget / 100.00);

		System.out.println("Your total budget in " + symbol + " is " + roundedForeignBudget + " " + symbol + ", which per day is " + roundedForeignBudgetTotalDays + " " + symbol + ".");
		printDivider();
	}

	public static void timeDifference(){
		Scanner input = new Scanner(System.in);
		System.out.print("What is the difference, in hours, between your home and your destination? ");
		int timeZoneDifference = input.nextInt();
		System.out.println("\nThat means when it is midnight at home, it will be " + (0 + timeZoneDifference) + ":00 in your travel destination and when it is noon at home, it will be " + (12 + timeZoneDifference) + ":00.");
		printDivider();

	}

	public static void countryArea(){
		Scanner input = new Scanner(System.in);
		System.out.print("What is the square area of your destination country in km2? ");

		double kilometers = input.nextDouble();
		double miles = kilometers / 2.58998811;
		double miles1 = miles * 100;
		double milesRounded = (int)miles1 / 100.00;

		System.out.println("\nIn miles2 (rounded) that is " + milesRounded + ".");

		printDivider();
	}

	public static void howFar(){
	}

	/*
	 * This method prints a horizontal divider to help make output look cleaner.
	*/
	public static void printDivider(){
		System.out.println("=======================================================================================");
	}
}
