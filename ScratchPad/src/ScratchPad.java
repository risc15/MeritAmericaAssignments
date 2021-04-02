import java.util.Scanner;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
*/

public class ScratchPad {

	/*
	 * Class variables defined at the top.
	 */

	private int[] members;

	/*
	 * These constants essentially mean: private - only accessible for this class.
	 * static - only defined once. There won't be another. final - will not change.
	 */

	private static final double PI = 3.14;
	private static final int STATUE_OF_LIB_HEIGHT_INCHES = 1813;

	public static void main(String[] args) {
		
		System.out.println(isPalindrome("cool"));
		System.out.println(hailstoneSequence(-100));
	}
	
	public static int hailstoneSequence(int n) {
		n = Math.abs(n);
		System.out.println(n);
		if (n == 1) {
			return 1;
		} else if (n % 2 == 0 ) {
			return hailstoneSequence(n / 2);
		} else {
			return hailstoneSequence((n * 3) + 1);
		}
	}
		
	public static boolean isPalindrome(String word) {
		word.toLowerCase();
		for (int x = 0; x < (word.length() - 1) - x; x++) {
			if (word.charAt(x) != word.charAt((word.length() - 1) - x)) {
				return false;
			}
		}
		return true;
	}

	public static long factors(long n, long p) {

		ArrayList<Long> myArray = new ArrayList<Long>();
		int incrementer = n % 2 == 0 ? 1 : 2;

		for (long i = 1; i <= Math.sqrt(n); i += incrementer) {

			if (n % i == 0) {
				myArray.add(i);

				// Add the result to end:
				if (i != n / i) {
					myArray.add(n / i);
				}
			}

		}
		Collections.sort(myArray);
		return myArray.get((int) p - 1);
	}

	/*
	 * public static long pthFactor(long n, long p) { // Write your code here
	 * ArrayList<Long> myArray = new ArrayList<Long>();
	 * 
	 * for (long i = 1; i <= n; i++) { if (n % i == 0) { myArray.add(i); }
	 * 
	 * if (myArray.size() == p) { return myArray.get((int) p - 1); } } return 0l; }
	 * 
	 */

	public static char myMethod() {
		char currentChar;
		int highestCount = 0;
		String text = "You know what they say: All toaster toast toast.";

		LinkedHashMap<Character, Integer> myMap = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < text.length(); i++) {
			// Set the current character:
			currentChar = text.charAt(i);

			// Add/update keypair:
			if (!myMap.containsKey(currentChar)) {
				myMap.put(currentChar, 1);
			} else {
				myMap.put(currentChar, myMap.get(currentChar) + 1);
				if (myMap.get(currentChar) > highestCount) {
					highestCount = myMap.get(currentChar);
				}
			}
		}

		/*
		 * This returns the first occurrence of the highest count character:
		 */
		for (int i = 0; i < text.length(); i++) {
			// Set the current character:
			currentChar = text.charAt(i);

			if (myMap.get(currentChar) == highestCount) {
				System.out.println(myMap);
				return currentChar;
			}
		}

		return ' ';
	}

	/*
	 * Here is an unnecessary method that converts a double to int. This is purely
	 * for review as it is easier to (cast) things rather than to create a method
	 * for something already built- in...
	 */

	public static int doubleToInt(double x) {
		System.out.println("Demonstrating type casting.");
		System.out.println("Casting double " + x + " to int:");
		System.out.println("============================");
		int y = (int) x;
		return y;
	}

	public static void pemdas() {
		System.out.println("Demonstrating the order of operations:");
		System.out.println();
	}

	public static void constants() {
		System.out.println("There are times where you don't need a value to change.");
		System.out.println("These are called constants:");
		System.out.println("=======================================================");

		System.out.println("This is a constant:" + PI);
	}

	public static void fibonacci() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input a number to see the fibonacci sequence up to it: ");
		int count = input.nextInt();

		ScratchPad fib = new ScratchPad();
		fib.members = new int[count];

		fib.members[0] = 1;
		fib.members[1] = 1;

		System.out.println("Fibonacci sequence up to nth term:");
		System.out.print(fib.members[0] + " " + fib.members[1]);

		for (int i = 2; i < count; i++) {
			fib.members[i] = fib.members[i - 1] + fib.members[i - 2];
			System.out.print(" " + fib.members[i]);
		}

		input.close();
	}
}
