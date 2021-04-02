import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class PhoneBook {

	/*
	 * Instance variables:
	 */
    private FastScanner in = new FastScanner();   
    private String[] phoneBook = new String[10000000];

    /*
     * main method:
     * 
     * Creates a phone book and processes queries.
     */
    public static void main(String[] args) {
        new PhoneBook().processQueries();
    }
    
    /*
     * processQueires
     * 
     * The first input given sets the number of queries.
     * Then the folowing inputs create the various contact
     * objects.
     */
    public void processQueries() {
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i)
            processQuery(readQuery());
    }

    private void processQuery(Query query) {
        if (query.type.equals("add")) {
        	
//        	int indexNumber = query.number % (phoneBook.length - 1);
            phoneBook[query.number] = query.name;
        } else if (query.type.equals("del")) {
        	
//        	int indexNumber = query.number % (phoneBook.length - 1);
        	phoneBook[query.number] = null;
        } else {
        	String response = "not found";
        	
 //       	int indexNumber = query.number % (phoneBook.length - 1);
        	if (phoneBook[query.number] != null) {
        		response = phoneBook[query.number];
        	}
        	writeResponse(response);
        }
    }
    
    private Query readQuery() {
        String type = in.next();
        int number = in.nextInt();
        if (type.equals("add")) {
            String name = in.next();
            return new Query(type, name, number);
        } else {
            return new Query(type, number);
        }
    }

    private void writeResponse(String response) {
        System.out.println(response);
    }

// Classes: =================================================================================================================================
    
    static class Contact {
        String name;
        int number;

        public Contact(String name, int number) {
            this.name = name;
            this.number = number;
        }
    }

    static class Query {
        String type;
        String name;
        int number;

        public Query(String type, String name, int number) {
            this.type = type;
            this.name = name;
            this.number = number;
        }

        public Query(String type, int number) {
            this.type = type;
            this.number = number;
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
