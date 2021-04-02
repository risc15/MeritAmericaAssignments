/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// This program creates a checker board pattern on any size world without obstacles.
	// Requires Karel to start in the bottom left facing east.
	
	public void run() {
		fillRowEast();
		fillRowWest();
	}
	
//========================================================================================================================
//Methods:
//========================================================================================================================

	/*
	 *  Karel moves east placing a beeper every other step as long as the path is clear.
	 *  Requires Karel to be facing east.
	 */
	private void fillRowEast() {
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
			} else {
				putBeeper();
				move();
			}
			if (frontIsClear()) {
				move();
				putBeeper();
			}
		}
		
		nextRowCheckEast();
	}
	
	private void nextRowCheckEast() {
		turnLeft();
		if (frontIsClear()) {
			move();
			turnLeft();
		} else {
			spin();
		}
	}
	
	private void fillRowWest() {
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
			} else {
				putBeeper();
				move();
			}
			if (frontIsClear()) {
				move();
			}
		}
		
		nextRowCheckWest();
	}
	
	private void nextRowCheckWest() {
		turnRight();
		if (frontIsClear()) {
			move();
			turnRight();
			run();
		} else {
			spin();
		}
	}
	
	private void spin() {
		turnAround();
		spin();
	}
	
}
