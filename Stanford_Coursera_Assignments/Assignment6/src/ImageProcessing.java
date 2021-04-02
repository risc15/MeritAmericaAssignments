// File: ImageProcessing.java

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class ImageProcessing extends GraphicsProgram{
	
	/*
	 * Class variables:
	 */
	private static final long serialVersionUID = 1L;
	private static GImage image = new GImage("Vermeer_Milkmaid.jpg");
	private static int counter;
	
	/*
	 * run
	 * 
	 * This is the start of the program. We call the flipHorizontal
	 */
	public void run() {
		add(flipHorizontal(image));
	}
	
	/*
	 * flipHorizontal
	 * 
	 * This method takes a GImage as input and turns it into a pixel array.
	 * This array is simply an array of integers, which makes it easy to
	 * manipulate.
	 * 
	 * The two for loops go through the vertical and horizontal positions
	 * of the pixels and writes to a new array in reverse order horizontally.
	 * 
	 * We output a new GImage with the newArray as its input.
	 */
	public GImage flipHorizontal(GImage image) { 
		int[][] array = image.getPixelArray();
		int[][] newArray = image.getPixelArray();
		int width = array.length;
		int height = array[0].length;
		
		for(int i = 0; i < width; i++) {
			counter = 0;
			for(int j = height - 1; j >= 0; j--) {
				newArray[i][counter] = array[i][j];
				counter++;
			}
		}
		
		return new GImage(newArray);
	}
	
}

/*
 * 
 * Old array:
 * [0][1][2][3][4][5][6][7][8][9][10][11][12][13][14][15][16] = array[0][x]
 * [][][][][][][][][][][][][][][][][]						  = array[1][x]
 * [][][][][][][][][][][][][][][][][]						  = array[2][x]
 * [][][][][][][][][][][][][][][][][]						  = array[3][x]
 * [][][][][][][][][][][][][][][][][]						  = array[4][x]
 * [][][][][][][][][][][][][][][][][]						  = array[5][x]
 * 
 * New array:
 * [16][15][14][13][12][11][10][9][8][7][6][5][4][3][2][1][0] = newArray[0][x]
 * [][][][][][][][][][][][][][][][][] 						  = newArray[1][x]
 * [][][][][][][][][][][][][][][][][]						  = newArray[2][x]
 * [][][][][][][][][][][][][][][][][]						  = newArray[3][x]
 * [][][][][][][][][][][][][][][][][]						  = newArray[4][x]
 * [][][][][][][][][][][][][][][][][]						  = newArray[5][x]
 * 
 */
