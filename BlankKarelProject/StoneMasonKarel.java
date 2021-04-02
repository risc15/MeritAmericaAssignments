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

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		repairColumn();
		nextColumn();
	}
	
//========================================================================================================================
// Methods below:
//========================================================================================================================

	/*
	 * repairColumn
	 * 
	 * This method requires Karel to be "on the ground" facing east.
	 * Karel will turn left and while going up, replace missing beepers.
	 * Once Karel reaches the top, he will go back down and face east.
	 * This is set up for any column size.
	 * 
	 */
	
	private void repairColumn() {
		turnLeft();
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
			} else {
				putBeeper();
				move();
			}
		}if (beepersPresent()) {
			turnAround();
		} else {
			putBeeper();
			turnAround();
		}
		
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
	
	/*
	 *  This method checks of Karel's path is clear east. If it is,
	 *  proceed forward 4 spaces. If Karel runs into a wall, the
	 *  program terminates. If 4 moves were successful, the program
	 *  will loop.
	 */
	
	private void nextColumn() {
		
		for (int i = 1;i <= 4; i++) {
			if (frontIsClear()) {
				move();
			} else {
				spin();
			}
		}
		
		run();
	}
	
	/*
	 *  This makes Karel spin in place forever. Marks the end of my
	 *  program.
	 */
	
	private void spin() {
		turnRight();
		spin();
	}

}
