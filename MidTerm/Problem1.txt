import stanford.karel.SuperKarel;

public class Problem1Karel extends SuperKarel{

	public void run() {

		init();
		runProgram();
		
	}
	
	public void init() {
		turnLeft();
		move();
		turnRight();
		move();
		move();
	}
	
	public void runProgram(){
		
		while(!beepersPresent()) {
			
			while(frontIsClear()) {
				putBeeper();
				move();
			}
	
			turnAround();
			move();
			turnAround();
			turnLeft();
			move();
		}
	}
}
