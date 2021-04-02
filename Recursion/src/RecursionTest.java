public class RecursionTest {
	
	public Integer i2 = 02;
	
	int add(int i, int j) {
		return i+j;
	}
	
	public static void main(String[] args) {
		int array[] = {3,4,5};
		
		System.out.println(array[2]);
		
		int i = 0;
	       do {
	           i++;
	       }
	       while(i < 0);
	       System.out.println(i);
	System.out.println(starString(4));
	System.out.println(repeat("Butts", 8));
	//System.out.println(repeat("Flintstones, meet the Flintstones!\n", 500));
		
	}
	
	public static String starString(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		} else if (n == 0) {
			System.out.println("n reached 0.");
			return "*";
		} else {
			return starString(n - 1) + starString(n - 1);
		}
	}

	final static String repeat(String s, int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		} else if (n == 0) {
			return "";
		} else {
			return s + repeat(s, n - 1);
		}
	}

}