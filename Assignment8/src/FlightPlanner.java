import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.IOException;
import java.util.ArrayList;
import acm.program.ConsoleProgram;

public class FlightPlanner extends ConsoleProgram {

	/*
	 * Instance Variables
	 */

	private static String startingCity;
	private static String currentCity;
	private static ArrayList<String> cities = new ArrayList<>();
	private static ArrayList<Flight> flights = new ArrayList<>();
	private static ArrayList<String> flightPlan = new ArrayList<>();
	private static ArrayList<String> availableFlights = new ArrayList<>();
	private static boolean running;

	/*
	 * run:
	 */

	public void run() {
		println("Welcome to Flight Planner!");
		getFlightList();
		printCitiesDatabase();
		println("Let's plan a round-trip route!");
		setStartingCity();
		running = true;
		
		while(running) {
			selectNextDestination();
		}
		printFlightPlan();
	}

	/*
	 * Class Methods
	 */

	private void getFlightList() {

		String file = "flights.txt";
		String delimiter = " -> ";
		String line;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {

				if (!line.isEmpty()) {
					String[] attr = line.split(delimiter);
					flights.add(new Flight(attr[0], attr[1]));

					// Add unique cities to a list:
					if (!(cities.contains(attr[0]))) {
						cities.add(attr[0]);
					}

					if (!(cities.contains(attr[1]))) {
						cities.add(attr[1]);
					}
				}

			}

			br.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void printCitiesDatabase() {
		println("Here's a list of all the cities in our database: ");
		for (String str : cities) {
			println(str);
		}
	}

	private void setStartingCity() {

		while (true) {
			startingCity = readLine("Enter starting city: ");
			if (!(cities.contains(startingCity))) {
				println("This city does not exist in our database, please try again.");
			} else {
				System.out.println("Starting city set to: " + startingCity);
				currentCity = startingCity;
				flightPlan.add(startingCity);
				break;
			}
		}
	}

	private void printAvailableFlights() {
		println("From " + currentCity + " you can fly directly to:");
		availableFlights.clear();
		// print a list of flights with the starting city as the current city:
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getStart().equals(currentCity)) {
				availableFlights.add(flights.get(i).getDestination());
				println(flights.get(i).getDestination());

			}
		}
	}

	private void selectNextDestination() {

		printAvailableFlights();
		String tempCity = readLine("Enter next destination: ");

		if (tempCity.equals(startingCity)) {
			running = false;
		} else if (availableFlights.contains(tempCity)) {
			flightPlan.add(tempCity);
			System.out.println(tempCity + " added to the flight plan.");
			currentCity = tempCity;
			println("Where do you want to go from " + tempCity + "? ");
		} else {
			println("You can't go to " + tempCity + " by direct flight. Please try again.");
		}
	}
	
	private void printFlightPlan() {
		
		println("The route you've chosen is: ");
		
		for (String str : flightPlan) {
			print(str + " -> ");
		}
		print(startingCity + "\n");
	}
}
