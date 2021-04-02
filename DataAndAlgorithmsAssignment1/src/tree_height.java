/*
 * tree_height.java
 * 
 * This program 
 */

import java.util.*;
import java.io.*;

public class tree_height {

	/*
	 * Main method:
	 * 
	 * This runs the run method and sets up a thread:
	 */
	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new tree_height().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	/*
	 * Run method:
	 */
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}

	/*
	 * Node Class:
	 * 
	 * The Node class contains nodes for a tree. A node has:
	 * 
	 * A key, or value.
	 * 
	 * A list of children.
	 * 
	 * [ Parent ] -> [ Child 1 ] [ Child 2 ] [ etc... ]
	 * 
	 * 
	 */
	class Node {
		private int key;
		private Node parent;
		private ArrayList<Node> children = new ArrayList<Node>();
		
		public void setParent(Node node) {
			this.parent = node;
		}
		
		public Node getParent() {
			return this.parent;
		}
		
		public void setKey(int key) {
			this.key = key;
		}

		public int getKey() {
			return this.key;
		}

		public void addChild(Node node) {
			this.children.add(node);
		}
		
		public void removeChild(int index) {
			this.children.remove(index);
		}

		public ArrayList<Node> getChildren() {
			return this.children;
		}
		
		
	}
	
	/*
	 * FastScanner Class:
	 * 
	 * This gives me the input for the tree, don't modify.
	 */
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	/*
	 * TreeHeight Class: 
	 * 
	 * The TreeHeight class gives two methods:
	 * 
	 * read(): Reads from a fast scanner. The first input is the length, or how many nodes there are.
	 * The rest of the data are keys for nodes. These are stored in an array. I will change it to 
	 * create an array of nodes to make the process faster.
	 * 
	 * The parents and children are then set up.
	 * 
	 * computeHeight(): Will use preorder traversal to find the height of the tree.
	 * 
	 */
	public class TreeHeight {
		int n;
		Node[] nodes;
		int rootNodeIndex = 0;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			nodes = new Node[n]; 							// Create an array of Nodes the size of n (the first input number).
			int[] parents = new int[n];						// create an array of parents the size of n.
			
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node();						// Create an empty node.
				parents[i] = in.nextInt();					// Get the values.
			}
			
			for (int i = 0; i < n; i++) {					// For loop running for the size of n.
				nodes[i].setKey(i);
				if (parents[i] == -1) {						// If the value is -1, that will be the root node.
					rootNodeIndex = nodes[i].getKey();
				} else {									// Else, 
					nodes[i].setParent(nodes[parents[i]]);	// The node in the Node array gets its parent set to the parent value in parents.
					nodes[parents[i]].addChild(nodes[i]);	// Give that parent node a child.
				}
			}
		}

		int computeHeight() {								// Got assistance from office hours for this:
			Queue nodeQueue = new LinkedList<>();
			nodeQueue.add(rootNodeIndex);
			int height = 0;

			while (!nodeQueue.isEmpty()) {
				int size = nodeQueue.size();
				for (int i = 0; i < size; ++i) {
					int node = (int) nodeQueue.remove();
					for (Node tempNode : nodes[node].getChildren()) {
						nodeQueue.add(tempNode.getKey());
					}
				}
				height++;
			}
			return height;
		}
	}
}
