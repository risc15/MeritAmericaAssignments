/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class VotingBox extends SuperKarel {

	/*
	 *  This program will run as long as the path is clear after checking the box.
	 *  Karel will move into the box and check for a beeper. If there is a beeper,
	 *  move on to the next box. If there is no beeper, Karel will clean out said
	 *  box.
	 *  
	 *  Requires: Karel to start in the middle of the western side of the world 
	 *  facing east.
	 *  
	 */

	public void run() {
		while(frontIsClear()) {
			move();
			checkBox();
		}
	}
	
//========================================================================================================================
// User-Defined Methods below:
//========================================================================================================================

	/*
	 *  checkBox
	 *  ========
	 *  
	 *  If box has a beeper, don't do anything. If there is a beeper, run the clearBox method.
	 *  
	 *  Requires: Karel to be in the center of a voting box facing east.
	 */
	
	private void checkBox() {
		if(beepersPresent()) {	// We have beepers? Move on. There was no voting attempt.
			move();
		} else {
			cleanBox();			// No beepers, seek and destroy hanging chads.
		}
	}
	
	/*
	 *  cleanBox
	 *  ========
	 *  
	 *  This method clears the top and bottom boxes of beepers, then resets Karel's position.
	 *  
	 *  Requires: Karel to be in the center of a voting box facing east.
	 */
	
	private void cleanBox() {
		turnLeft();
		move();
		while(beepersPresent()) {	// While beepers remain on the space Karel is in, pick them up.
			pickBeeper();
		}
		turnAround();				// Go to bottom of voting box.
		move();
		move();
		while(beepersPresent()) {	// Same as above, pick up the beepers.
			pickBeeper();
		}
		turnAround();				// Return to center, face right, then leave the box.
		move();
		turnRight();
		move();
	}
	
}
