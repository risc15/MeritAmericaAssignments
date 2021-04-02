import java.util.Arrays;

public class StringManipulation {
	
	public static void main(String[] args) {
		//test1();
		String myString = "This is my custom string that contains letters and symbols: !@#$%^&";
		System.out.println(myString);
		System.out.println(everyOtherCaps(myString));
		System.out.println(reverseString(myString));
		System.out.println(encryptCeaser(myString,5));
		System.out.println(reverseString(encryptCeaser(myString,5)));
	}
	
	private static void test1() {
		String letters = "abc";
		String[] letterArray = letters.split("");			// creates a string array.

		System.out.println(letterArray[1]);
		System.out.println(Arrays.toString(letterArray));	// Prints the entire array.
		
		char[] characterArray = letters.toCharArray();
		System.out.println(Arrays.toString(characterArray));
		
		String longString = "This is a long string with spaces inside.";
		String[] longStringArray = longString.split(" ");
		System.out.println(Arrays.toString(longStringArray));
		
		StringBuilder mySB = new StringBuilder("");
		//int counter = 0;
		
		System.out.println(longStringArray.length);
		
		for(int i = longStringArray.length - 1; i >= 0; i--) {
			//System.out.println(i);
			//System.out.println(counter);
			mySB.append(longStringArray[i]);
			mySB.append(" ");
		}
		
		System.out.println(mySB);
		System.out.println("The capacity of the string builder is: " + mySB.capacity());
	}
	
	public static String reverseString(String stringToReverse) {
		char[] characterArray = stringToReverse.toCharArray();
		StringBuilder mySB = new StringBuilder("");
		
		for(int i = characterArray.length -1 ; i >= 0; i--) {
			mySB.append(characterArray[i]);
		}
		
		return mySB.toString();
	}
	
	public static String everyOtherCaps(String stringToManipulate) {
		String[] characterStringArray = stringToManipulate.split("");
		StringBuilder mySB = new StringBuilder("");
		
		for(int i = 0; i < characterStringArray.length; i++) {
			if((i & 1) == 1) {
				mySB.append(characterStringArray[i]);
			} else {
				characterStringArray[i] = characterStringArray[i].toUpperCase();
				mySB.append(characterStringArray[i]);
			}
				
		}

		return mySB.toString();
		// 
	}
	
	public static String encryptCeaser(String str, int key) {
		String result = "";
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			result += encryptChar(ch, key);
		}
		return result;
	}
	
	private static char encryptChar(char ch, int key) {
		
		if (Character.isUpperCase(ch)) {
			return (char)('A' + ((ch - 'A' + key) % 26));
		} else if (Character.isLowerCase(ch)) {
			return (char)('a' + ((ch - 'a' + key) % 26));
		} else {
			return ch;
		}
	}
	
}
