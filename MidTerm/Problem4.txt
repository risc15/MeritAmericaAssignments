import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Problem4 extends GraphicsProgram{

	/*
	 * Constants:
	 */
	private static final int SQSIZE = 75;
	private static final int NCOLS = 7;
	private static final int NROWS = 3;
	public static final int APPLICATION_WIDTH = NCOLS * SQSIZE;
	public static final int APPLICATION_HEIGHT = NROWS * SQSIZE;
	
	/*
	 * Class variables:
	 */
	private static int frogXGrid = 4;
	private static int frogYGrid = 2;
	private static int mouseX;
	private static int mouseY;
	GImage frog = new GImage("frog.gif",SQSIZE * frogXGrid,SQSIZE * frogYGrid);
	
	/*
	 * run
	 * 
	 * The start of the program. This simply moves a poor quality image of a frog
	 * that I have no right to claim in the direction the mouse is from the image
	 * itself.
	 * 
	 */
	public void run() {
		initialize();
		while(true) {
			
		}
	}
	
	/*
	 * initialize
	 * 
	 * Sets up the game.
	 */
	public void initialize() {
		addMouseListeners();
		add(frog);
	}
	
	/*
	 * mouseClicked
	 * 
	 * This checks if the mouse is clicked. If it was, save the mouse location and
	 * make the frog jump in the direction of the mouse.
	 * 
	 */
	public void mouseClicked(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		jumpFrog();
		println("Frog at grid: " + frogXGrid + ", " + frogYGrid);
		println("Frog image at: " + getXPosition(frog) + ", " + getYPosition(frog));
		println("Mouse clicked at: " + mouseX + " " + mouseY);
	}
	
	/*
	 * movement methods
	 * 
	 * These do as they say:
	 */
	public void jumpNorth() {
		if(frogYGrid > 0) {
			frog.move(0, -SQSIZE);
			frogYGrid--;
		} else println("Ouch, ribbit!");
	}
	
	public void jumpSouth() {
		if(frogYGrid < NROWS - 1) {
			frog.move(0,SQSIZE);
			frogYGrid++;
		} else println("Ouch, ribbit!");
	}
	
	public void jumpEast() {
		if(frogXGrid < NCOLS - 1) {
			frog.move(SQSIZE, 0);
			frogXGrid++;
		} else println("Ouch, ribbit!");
	}	

	public void jumpWest() {
		if(frogXGrid > 0) {
			frog.move(-SQSIZE, 0);
			frogXGrid--;
		} else println("Ouch, ribbit!");
	}
	
	/*
	 * jumpFrog
	 * 
	 * This gets the difference between the mousex and frogx and checks the difference between
	 * the mousey and frog y, and sees which one is closer. If the mouse is closer to the x axis,
	 * we then check which side of the graphic we are clicking on. Similar to the y axis.
	 * 
	 * We then jump the frog in that direction.
	 */
	public void jumpFrog() {

		if( Math.abs(mouseX - getXPosition(frog)) > Math.abs(mouseY - getYPosition(frog)) ) {
			if(mouseX < getXPosition(frog) ) {
				jumpWest();
			} else jumpEast();
		}
		
		if( Math.abs(mouseX - getXPosition(frog)) < Math.abs(mouseY - getYPosition(frog))) {
			if(mouseY < getYPosition(frog)) {
				jumpNorth();
			} else jumpSouth();
		}

	}
	
	/*
	 * These two methods returns the x or y position of the center of a GImage.
	 */
	public double getXPosition(GImage image) {
		return image.getX() + SQSIZE / 2;
	}
	
	public double getYPosition(GImage image) {
		return image.getY() + SQSIZE / 2;
	}
}
