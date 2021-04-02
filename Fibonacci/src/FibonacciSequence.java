
public class FibonacciSequence {
	
	/*
	 * Class Variables:
	 */

	private static int term;
	
	/* 
	 * Class Constants:
	 */
	private static final int MAX_TERM_VALUE = 10000;
	
	/*
	 * This program utilizes recursion to calculate and print
	 * the Fibonacci Sequence. This is still really difficult
	 * to visualize for our group, but I'll try to explain.
	 * These notes are for my understanding as well.
	 * 
	 * We are trying to avoid using an array since we will
	 * assume we do not know how long the sequence will be.
	 * We want to print the sequence up to or less than
	 * 10,000.
	 * 
	 * We will create an object that will hold value: term
	 * and have access to the formula method. We also declare
	 * a counter to be passed into the formula method.
	 * 
	 * The while loop calls the formula and checks the output
	 * against the MAX_TERM_VALUE. Inside the while loop, we
	 * print the current term value then increase the count
	 * to go to the next number. The condition check for the
	 * while loop is doing the heavy lifting.
	 * 
	 * The formula method will technically keep computing
	 * the Fibonacci sequence until the integer term can't
	 * hold the value any longer (or a stack overflow). It
	 * relies on the while loop check to end.
	 * 
	 * The Fibonacci sequence takes the previous two numbers
	 * and adds them together. The formula (not the method)
	 * looks like this: 
	 * 
	 * F(0) = 0						These are the base cases.
	 * F(1) = 1
	 * F(n) = F(n - 1) + F(n - 2)	This is recursive.
	 * 
	 * Remember, recursive functions need a base case and a
	 * function call.
	 * 
	 * With this information, we can construct the recursive
	 * method. Instead of saving the count and term to an array
	 * we simply calculate the needed numbers and print to 
	 * screen.
	 * 	  count	  value
	 * ====================
	 * 		0		0 starting value
	 * 		1		1 starting value
	 * 		2		1 (0 + 1)
	 * 		3		2 (1 + 1)
	 * 		4		3 (1 + 2)
	 * 		5
	 * 
	 * We need recursion since we are not saving previous values!
	 * Every time we need to print the next value in the sequence,
	 * we need to recursively re-calculate the entire sequence so 
	 * we get the correct values. We use the counter to know what
	 * number to start with each time. This means this program is
	 * really not all that efficient; especially once the numbers
	 * start getting really big. It is easier keeping an array,
	 * but this is more interesting.
	 */
	
	public static void main(String[] args) {
		int count = 0;
		FibonacciSequence fibo = new FibonacciSequence();
		
		while (fibo.formula(count) < MAX_TERM_VALUE) {
			System.out.println(term);
			count++;
		}
	}

	public int formula(int count) {
		if(count == 0) {
			return term = 0;
		} else if (count == 1) {
			return term = 1;
		} else {
			term = formula(count - 1) + formula(count -2);
			return term;
		}
		
	}
}
