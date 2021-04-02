import java.util.Arrays;

public class HashFunction {

	/*
	 * Instance variables:
	 */
	String[] theArray;
	int arraySize;
	int itemsInArray = 0;
	
	/*
	 * Constructor:
	 */
	HashFunction(int size) {
		arraySize = size; // Make sure this is twice the size of whatever amount you need.
		theArray = new String[size];
		// This is added purely for demonstration:
		Arrays.fill(theArray,  "-1");
	}
	
	/*
	 * Main:
	 */
	public static void main(String[] args) {
		
		HashFunction theFunc = new HashFunction(30);
		
		String[] elementsToAdd2 = {"100", "510", "170", "214", "268", "398", "235", "802", "900", "723",
                "699", "1", "16", "999", "890", "725", "998", "978", "988", "990", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624"};

        theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);

        theFunc.findKey("660");
		
		theFunc.displayTheHashTable();
	}
	
// Class methods //================================================
	
	public void hashFunction1(String[] stringsForArray, String[] inputArray) {
		for (int n = 0; n < stringsForArray.length; n++) {
			String newElementVal = stringsForArray[n];
			inputArray[Integer.parseInt(newElementVal)] = newElementVal;
		}
	}
	
	public void hashFunction2(String[] stringsForArray, String[] inputArray) {
		
		for(int n = 0; n < stringsForArray.length; n++) {
            String newElementVal = stringsForArray[n];

            int arrayIndex = Integer.parseInt(newElementVal) % (this.arraySize - 1);

            System.out.println("Modulus Index= " + arrayIndex + " for value " + newElementVal);

            while (theArray[arrayIndex] != "-1") {

                ++arrayIndex;

                System.out.println("Collision Try " + arrayIndex + " instead");

                arrayIndex %= arraySize;
            }

            theArray[arrayIndex] = newElementVal;
        }
	}
	
	public String findKey(String key) {
        int arrayIndexHash = Integer.parseInt(key) % (this.arraySize - 1);

        while(theArray[arrayIndexHash] != "-1") {
            if (theArray[arrayIndexHash] == key) {

                System.out.println(key + " was found in index " + arrayIndexHash);

                return theArray[arrayIndexHash];
            }
            ++arrayIndexHash;

            arrayIndexHash %= arraySize;
        }
        return null;
    }
	
	public void displayTheHashTable() {
		for(String s: theArray) {
			System.out.println(s);
		}
	}
	
}
