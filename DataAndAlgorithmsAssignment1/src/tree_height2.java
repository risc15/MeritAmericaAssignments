import java.util.*;
import java.io.*;

public class tree_height2 {
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

	public class Node {
		private int key;
		private Node parent;
		private boolean checked;
		private ArrayList<Node> children = new ArrayList<>();

		public boolean hasParent() {
			if (this.parent == null) {
				return false;
			} else {
				return true;
			}
		}

		public boolean hasChildren() {
			if (this.children.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public boolean isChecked() {
			return checked;
		}

		public void setChecked(boolean checked) {
			this.checked = checked;
		}

		public void addChild(Node child) {
			this.children.add(child);
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public ArrayList<Node> getChildren() {
			return this.children;
		}

		public String toString() {
			String temp = "";
			for (int i = 0; i < this.children.size(); i++) {
				temp += this.children.get(i).getKey();
			}
			return temp;
		}

	}

	public class TreeHeight {
		
		// class variables:
		
		int n;
		int root = 0;
		Node[] nodes;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			nodes = new Node[n];
			int[] parents = new int[n];

			for (int i = 0; i < n; i++) {
				nodes[i] = new Node();
				parents[i] = in.nextInt();
			}
			
			for (int i = 0; i < n; i++) {
				nodes[i].setKey(i);
				if (parents[i] == -1) {

					root = nodes[i].getKey();
				} else {
					nodes[i].setParent(nodes[parents[i]]);
					nodes[parents[i]].addChild(nodes[i]);
				}
			}
		}

		int computeHeight() {
			// Replace this code with a faster implementation

			Queue qu = new LinkedList<>();
			qu.add(root);
			int height = 0;

			while (!qu.isEmpty()) {
				int sz = qu.size();
				for (int i = 0; i < sz; ++i) {
					int node = (int) qu.remove();
					for (Node v : nodes[node].getChildren()) {
						qu.add(v.getKey());
					}
				}
				height++;
			}
			return height;
		}
	}

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

	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}