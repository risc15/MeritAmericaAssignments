import java.io.*;
import java.util.Scanner;

public class WordCount {
	
	/*
	 * Static class variables:
	 */
	private static int lineCount = 0;
	private static int wordCount = 0;
	private static int charCount = 0;
	private static String tempLine = "";
	private static Scanner userInput = new Scanner(System.in);

	/*
	 * Main
	 */
	public static void main(String[] args) {
		readFile();
	}

	/*
	 * readFile
	 * 
	 * 
	 */
	public static void readFile() {

		// Get the name of the file to open:
		System.out.print("File: ");
		String fileName = userInput.nextLine();
		

		// Open the file of file name, fileName:
		try {
			File textFile = new File(fileName);
			FileReader reader = new FileReader(textFile);
			BufferedReader bufferedReader = new BufferedReader(reader);

			while ((tempLine = bufferedReader.readLine()) != null) {
				charCount += tempLine.length();
				String[] lineArray = tempLine.split("( )|(')");
				wordCount += lineArray.length;
				lineCount++;
				
				//System.out.println(tempLine);
			}
			
			System.out.println("");
			System.out.println("Line count: " + lineCount);
			System.out.println("Word count: " + wordCount);
			System.out.println("Character count: " + charCount);
			// Close the reader:
			reader.close();


		} catch (FileNotFoundException e) {
			System.out.println("File was not found.");
		} catch (IOException e) {
			System.out.println("Input/output exception.");
		}
	}
}
