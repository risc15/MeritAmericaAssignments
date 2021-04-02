/**
 * 
 * @author rod
 * 
 * This class provides methods for working with an array that expands
 * to include any positive index value supplied by the caller.
 *
 */
public class ExpandableArray {
	
	/*
	 * Instance variables:
	 */
	
	private Object[] expandableArray;
	
	/*
	 * Constructor:
	 * 
	 * Creates an expandable array with no elements.
	 * 
	 */
	public ExpandableArray() {
		this.expandableArray = new Object[0];
	}
	
	/** 
	 * Sets the element at the given index position to the specified value. 
	 * If the internal array is not large enough to contain that element, 
	 * the implementation expands the array to make room.
	 * 
	 * We start by looking at the index. If it is greater than
	 * the array's current size, we make a new array, copy the old array
	 * values to the new one, put the new value into the new array, then
	 * set the old array to point to the new array.
	 * 
	 * If the array is larger than the index, we simply add the value to the
	 * array.
	 */
	public void set(int index, Object value) {
			
			if(index + 1> this.expandableArray.length) {
				
				Object[] newArray = new Object[index + 1];
				
				for(int i = 0; i < this.expandableArray.length; i++) {
					newArray[i] = this.expandableArray[i];
				}
				
				newArray[index] = value;
				this.expandableArray = newArray;
			} else if(index < 0){
				
				System.out.println("Index cannot be less than zero, no operation attempted.");
			} else {
				
				this.expandableArray[index] = value;
			}
		}
	
	/**
	 * Returns the element at the given index position, or null if no such
	 * element exists. This method never throws an OutOfBoundsException; if
	 * the index is outside the bounds of the array, the return value is 
	 * simply null.
	 * 
	 */
	public Object get(int index) {
		if(index < 0 || index > this.expandableArray.length - 1) {
			return null;
		} else {
			return this.expandableArray[index];
		}
	}
}
