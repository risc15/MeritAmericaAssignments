/*
 * File: check_brackets.java
 * 
 * This program reads through an input string and checks to see if pairs of brackets
 * match each other. Will tell you the first position of a mismatched bracket.
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

/*
 * Bracket
 * 
 * This class creates a Bracket which contains a character and a position in the data stream.
 * A provided method checks whether or not a given character matches the opening bracket.
 * 
 */
class Bracket {
	
	char type;
    int position;

    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }
}

/*
 * check_brackets
 * 
 * This will look through an input strings and check if there are any mismatched
 * brackets. Will immediately break out and report when it comes across the first error.
 * 
 */
class check_brackets {
    public static void main(String[] args) throws IOException {
    	
    	//Setup our variables:
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        Bracket lastClosing = new Bracket('a', -1);
        
        // Start at the beginning of the input file and go through to the end.
        for (int position = 0; position < text.length(); ++position) {
        	// This reads the next character and sets it to next:
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
            	// Insert opening bracket:
                opening_brackets_stack.push(new Bracket(next,position));
                //System.out.println(next + " pushed to stack.");
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket:
            	
            	if (opening_brackets_stack.isEmpty()) {

            		lastClosing.position = position;
            		break;
            	}
            	
            	if(opening_brackets_stack.peek().Match(next)){
            		opening_brackets_stack.pop();
            	} else {
            		// Here's the error, break out now.
            		lastClosing.position = position;
            		break;
            	}
            }
        }
        
        if (opening_brackets_stack.isEmpty() && lastClosing.position == -1) {
    		System.out.println("Success");
    	} else {
    		if (lastClosing.position != -1) {
        		System.out.println(lastClosing.position + 1);
        	} else {
        		System.out.println(opening_brackets_stack.peek().position + 1);
        	}
    	}
    }
}
