package longestname;
import java.util.Scanner;

public class LongestName {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		myRoutine(input,5);
		triangle();
		test();
	}
	
	static void myRoutine(Scanner console,int n) {

		String name;
		String newName;
		String longestName = "";
		boolean tie = false;

		for (int i = 1; i <= n; i++) {
			System.out.print("name #" + i + "? ");
			name = console.next();

			newName = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();

			if (newName.length() > longestName.length()) {
				longestName = newName;
				tie = false;
			} else if (newName.length() == longestName.length()) {
				tie = true;
			}
		}

		System.out.println(longestName +  "'s name is longest");
		if (tie) { System.out.println("(There was a tie!)");}
	}
	
	static void triangle() {
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}
			System.out.print("\n");
		}
	}
	
	static void test() {
		int x = 1;
		while (x < 100) {
			System.out.print(x + " ");
			x += 10;
		}
		
		x = 2;
		while (x < 200) {
			System.out.println(x + " ");
			x *= x;
		}
		
		x = 100;
		while (x > 0) {
			System.out.println(x / 10);
			x = x / 2;
		}
		
		System.out.println("10 plus 20 is " + 10 + 20);
	}
}
