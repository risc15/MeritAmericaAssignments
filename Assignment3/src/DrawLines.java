import java.awt.event.*;
import acm.program.*;
import acm.graphics.*;

public class DrawLines extends GraphicsProgram{
	
	/*
	 * Instance variables:
	 */

	private static final long serialVersionUID = 1L;
	private GLine line;

	public void init () {
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		this.line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
		add(this.line);
		}
	
	public void mouseDragged(MouseEvent e) {
		line.setEndPoint(e.getX(), e.getY());
		}

}