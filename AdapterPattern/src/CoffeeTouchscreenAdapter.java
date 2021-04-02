
public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface{
	
	private OldCoffeeMachine coffeeMachine;
	
	public CoffeeTouchscreenAdapter(OldCoffeeMachine newMachine) {
		this.coffeeMachine = newMachine;
	}
	
	public boolean chooseFirstSelection() {
		return this.coffeeMachine.selectA();
	}
	
	public boolean chooseSecondSelection() {
		return this.coffeeMachine.selectB();
	}
	
}
