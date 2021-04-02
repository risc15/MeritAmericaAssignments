import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class HashChains {

	/*
	 * Instance variables:
	 */
    private FastScanner in;
    private PrintWriter out;
    // store all strings in one list
    private LinkedList<String>[] array;
    // for hash function
    private int bucketCount;
    private int prime = 1000000007;
    private int multiplier = 263;

    /*
     * Main method:
     */
    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

// Class Methods /===========================================================================================================================
    
    public void processQueries() throws IOException {

        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        int queryCount = in.nextInt();
        array = new LinkedList[queryCount * 2];
        for (int i = 0; i < queryCount * 2; i++) {
        	array[i] = new LinkedList<String>();
        }
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }
    
    private void processQuery(Query query) {
    	int index;
    	
        switch (query.type) {
            case "add":
            	 index = hashFunc(query.s);

                if (array[index].contains(query.s)) {
                	break;
                	}
                array[index].push(query.s);
                
                break;
            case "del":
            	index = hashFunc(query.s);
            	array[index].remove(query.s);
                break;
            case "find":
            	index = hashFunc(query.s);

            	writeSearchResult(array[index].contains(query.s));
                break;
            case "check":
            	
            	index = query.ind;
            	String output = "";
            	if (array[index].isEmpty()) {
            		System.out.println("");
            		break;
            	}
            	for (String s: array[index]) {
            		output+= s + " ";
            	}
            	output = output.substring(0, output.length() - 1);
            	System.out.println(output);

                // Uncomment the following if you want to play with the program interactively.
                // out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    
    private int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int)hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        System.out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        // out.flush();
    }

// Classes /=============================================================================================================================

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
