/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	public void run() {
		turnRight();
		spin();
		move();
		spin();
		turnLeft();
		spin();
		move();
		spin();
		move();
		spin();
		move();
		spin();
		pickBeeper();
		spin();
		turnAround();
		spin();
		move();
		spin();
		move();
		spin();
		move();
		spin();
		turnRight();
		spin();
		move();
		spin();
		turnRight();
		spin();
	}
	
	private void spin() {
		turnRight();
		turnRight();
		turnRight();
		turnRight();
	}

}
