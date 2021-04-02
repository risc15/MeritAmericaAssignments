import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class JobQueue {
	
	/*
	 * Instance variables:
	 */
    private int numWorkers;  
    private int[] jobs;
    private int[] assignedWorker;
    private long[] startTime;
    private FastScanner in;
    private PrintWriter out;

    /*
     * main
     * 
     * Create a new job queue and run the solve method.
     * 
     */
    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }
    
    /*
     * solve
     * 
     * The solve method creates a new fast scanner and print writer.
     * 
     * Then in order, we call the readData, assignJobs, and writeResponse methods.
     * 
     * Finally, close the scanner.
     * 
     */
    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    /*
     * readData
     * 
     * The first number read is the number of threads we have.
     * Next, we create an integer variable, m and assign it to the next input read.
     * 
     * Last, we create an array that holds the jobs themselves.
     */

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }
    
    /*
     * assignJobs
     * 
     * This is the part I'm re-writing. The whole point to this exercise is using a priority
     * queue.
     * 
     */
    private void assignJobs() {
    	assignedWorker = new int[jobs.length];
    	startTime = new long[jobs.length];
        Queue<Worker> queue = new PriorityQueue<>(numWorkers,compare);
        for (int i = 0; i < numWorkers; i++) {
        	queue.add(new Worker(i));
        }
        
        for(int i = 0;i<jobs.length;i++){
            int duration = jobs[i];
            Worker w = queue.poll();

            assignedWorker[i] = w.getWorkerNumber();
            startTime[i] = w.startTime;
            w.startTime+=duration;
            queue.add(w);
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

// Classes /=================================================================================================================
    
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
    
public class Thread {
    	
    }
    
    Comparator<Worker> compare = new Comparator<Worker>() {

        public int compare(Worker worker, Worker child) {
            if(worker.startTime == child.startTime){
            	
                if(worker.getWorkerNumber() < child.getWorkerNumber()) return -1;
                
                else if(worker.getWorkerNumber() > child.getWorkerNumber()) return 1;
                
                else return 0;
            }
            else if(worker.startTime < child.startTime) return -1;
            
            else if(worker.startTime > child.startTime) return 1;
            
            else return 0;

        }
    };
    
    public class Worker {
    	
    	private int workerNumber;
    	private long duration;
    	public long startTime;
    	public long next_free_time;
    	
    	public Worker(int workerNumber) {
    		this.workerNumber = workerNumber;
    		this.startTime = 0;
    	}
    	
    	public Worker(int workerNumber, long startTime) {
    		this.workerNumber = workerNumber;
    		this.startTime = startTime;
    	}
    	
    	public int getWorkerNumber() {
    		return workerNumber;
    	}
    	
    	public long getDuration() {
    		return duration;
    	}
    	
    	public void subtractDuration(long s) {
    		duration -= s;
    	}
    	
    	public long getStartTime() {
    		return startTime;
    	}
    }
}
