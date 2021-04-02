import java.awt.Color;
import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.*;

public class RandomCircles extends GraphicsProgram {

	/*
	 * Instance Variables:
	 */
	private static RandomGenerator rand = new RandomGenerator();
	
	/*
	 * Constants:
	 */
	private static final int MINIMUM_CIRCLE_RADIUS = 5;
	private static final int MAXIMUM_CIRCLE_RADIUS = 50;
	private static final long serialVersionUID = 1L;

	/*
	 * Run Method:
	 */
	public void run() {
		generateCircles(10000);
	}

	/**
	 * generateCircles()
	 * 
	 * This program generates a specified amount of circles of random size, color, and position.
	 * 
	 * @param circleCount - The amount of circles generated.
	 */
	private void generateCircles(int circleCount) {
		int counter = 0;
		int radius;
		int xPosition;
		int yPosition;
		Color circleColor;

		while(counter < circleCount) {
			radius = rand.nextInt(MINIMUM_CIRCLE_RADIUS,MAXIMUM_CIRCLE_RADIUS);
			xPosition = rand.nextInt(radius, (getWidth() - radius) );
			yPosition = rand.nextInt(radius, (getHeight() - radius) );
			circleColor = rand.nextColor();
			
			add(drawCircle(xPosition,yPosition,radius,circleColor));
//			System.out.println("Circle #" + counter 
//							+ ": Diameter: " + (radius * 2) 
//							+ " x: " + xPosition + " y: " + yPosition
//							+ " Color: " + circleColor);
			counter++;
		}
	}

	/*
	 * Creates a circle centered at the specified x and y location. 
	 * The user also provides a radius and color. Returns a GOval.
	 */
	public GOval drawCircle(double x, double y, int radius, Color color) {
		GOval circle = new GOval(x-radius,y-radius,radius*2,radius*2);
		circle.setFilled(true);
		circle.setFillColor(color);
		circle.setColor(color);
		return circle;
	}
}