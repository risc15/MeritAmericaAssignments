import java.util.*;

public class Anagram {
	public static void main(String[] args) {
		List<String> myArrayList = new ArrayList<String>();
		myArrayList.add("potato");
		myArrayList.add("tatopo");
		myArrayList.add("meat");
		myArrayList.add("bone");
		myArrayList.add("onbe");
		myArrayList.add("ebno");
		myArrayList.add("nobe");
		myArrayList.add("dallas");
		myArrayList.add("sallad");

		System.out.println(funWithAnagrams(myArrayList));
	}

	public static List<String> funWithAnagrams(List<String> text) {

		List<String> output = new ArrayList<String>();
		char[] arr1;
		char[] arr2;
		boolean matches;

		for (int i = 0; i < text.size(); i++) {

			matches = false;

			if (output.isEmpty()) {
				output.add(text.get(i));
			} else {
				for (int j = 0; j < output.size(); j++) {

					// Check of the lengths are the same:
					if (text.get(i).length() == output.get(j).length()) {

						// Set the character arrays:
						arr1 = text.get(i).toCharArray();
						arr2 = text.get(j).toCharArray();
						Arrays.sort(arr1);
						Arrays.sort(arr2);

						if (Arrays.equals(arr1, arr2)) {
							matches = true;
						}
					}
				}

				if (matches == false) {
					output.add(text.get(i));
				}
			}
		}

		output.sort(null);
		return output;

	}
}
