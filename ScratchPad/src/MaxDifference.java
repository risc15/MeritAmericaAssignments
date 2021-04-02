import java.util.List;

public class MaxDifference {

	/*
	 * The purpose of this code is to look through a list of numbers and find the
	 * greatest difference between two numbers in the list.
	 * 
	 * To speed things up, we only need to process numbers that are less than the
	 * current lowest value or greater than the maximum difference.
	 */

	public static int maxDifference(List<Integer> px) {

		int maxDif = -1;
		int lowestValue = px.get(0);

		// This for loop goes through the entire list (px)
		for (int i = 1; i < px.size(); i++) {

			// If the current number (i) is less than or equal to the previous number in the
			// list
			// and the current number is less than or equal to the lowest set value,
			// we set the lowest value to the current number:
			if (px.get(i) <= px.get(i - 1) && px.get(i) <= lowestValue) {
				lowestValue = px.get(i);

				// If the current number (i) minus the lowest value is greater than the maximum
				// difference,
				// then we set the maximum difference to the current number (i) minus the lowest
				// value.
			} else {
				if (px.get(i) - lowestValue > maxDif) {
					maxDif = px.get(i) - lowestValue;
				}
			}
		}
		return maxDif;

	}
}
