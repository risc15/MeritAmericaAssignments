import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.awt.Color;

public class GraphicsTesting extends GraphicsProgram {

	public void run() {
		GLabel label = new GLabel("Hello, world!", 100, 75);
		label.setFont("DejaVu Sans-36");
		label.setColor(Color.CYAN);
		add(label);
		
		GRect square = new GRect(10,10,100,100);
		square.setFilled(true);
		square.setColor(Color.BLACK);
		square.setFillColor(Color.BLUE);
		add(square);
		
	}
}