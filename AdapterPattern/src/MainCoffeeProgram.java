
public class MainCoffeeProgram {
	
	private static OldCoffeeMachine oldMachine = new OldCoffeeMachine();
	private static CoffeeTouchscreenAdapter coffeeMachineAdapter = new CoffeeTouchscreenAdapter(oldMachine);
	
	public static void main(String[] args) {
		System.out.println("Accessing the old machine: ");
		oldMachine.selectA();
		oldMachine.selectB();
		
		System.out.println("Accessing the old machine using the touchscreen adapter: ");
		coffeeMachineAdapter.chooseFirstSelection();
		coffeeMachineAdapter.chooseSecondSelection();
	}
}
