public class JPMorganTest {
	public static void main(String[] args) {
		String line = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		System.out.println(hashMethod(line));
		
	}
	
	public static int hashMethod(String line) {
		int total = 0;
		int[] array = new int[line.length()];
		
		// Take string and convert to integer array in reverse:
		for (int i = 0; i < line.length(); i++) {
			array[i] = Character.getNumericValue((line.charAt((line.length() - 1) - i)));
		}
		
		// Now that the array is reversed, I will add every even number to the total,
		// and every odd number will be multiplied by two if it is less than 9.
		// If greater than nine, the double digit is split into two separate numbers
		// then added to the total.
		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 0) {
				total += array[i];
			} else {
				if (array[i] * 2 > 9) {
					total += (array[i] * 2) - 9;
				} else {
					total += array[i]*2;
				}
			}
		}
		return total;
		
	}
	
}
