import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void test() {
		OldCoffeeMachine oldMachine = new OldCoffeeMachine();
		
		assertEquals(true, oldMachine.selectA());
		assertEquals(true, oldMachine.selectB());
		
		CoffeeTouchscreenAdapter newMachine = new CoffeeTouchscreenAdapter(oldMachine);
		
		assertEquals(true, newMachine.chooseFirstSelection());
		assertEquals(true, newMachine.chooseSecondSelection());
	}

}