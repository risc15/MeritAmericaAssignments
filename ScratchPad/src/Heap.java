
public class Heap {
	
	private int[] intArray;
	
	public Heap(int[] array) {
		this.intArray = array;
	}
	
	/*
	 * getParent
	 * 
	 * Returns the parent node of a child. If the input index is zero,
	 * this will return -1.
	 * 
	 */
	private int getParent(int i) {
		if( i == 0) {
			return -1;
		} else {
			return ((i - 1) / 2);
		}
	}
	
	/*
	 * getLastParent
	 * 
	 * Returns the last parent node of the array.
	 * i = the input index.
	 * 
	 */
	private int getLastParent(int i) {
		return (this.intArray.length / 2) - 1;
	}
	
	/*
	 * getLeftChild & getRightChild
	 * 
	 * Returns the left or right child node index.
	 * i = the input index.
	 * 
	 */
	private int getLeftChild(int i) {
		return i * 2 + 1;
	}
	
	private int getRightChild(int i) {
		return i * 2 + 2;
	}

	
	/*
	 * siftUp
	 * 
	 * This method will take the given index and swap it with its parent
	 * until it gets to the top.
	 * 
	 */
	private void siftUp(int i) {
		
		while (i > 1 && this.intArray[getParent(i)] < this.intArray[i]) {
			
			// Store the parent's value temporarily.
			int tempValue = this.intArray[getParent(i)];
			
			// Swap the two.
			this.intArray[getParent(i)] = this.intArray[i];
			this.intArray[i] = tempValue;

			 // Set I as the new index, we are now a level higher.
			i = getParent(i);

			// If the left child is greater than the right, we'll use the right instead.
			if (this.intArray[i] > this.intArray[i + 1]) i++;
		}
	}
}
