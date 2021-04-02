import java.util.ArrayList;

import Models.CreditCard;
import Models.CreditCardFactory;

public class Application {
	public static void main(String[] args) {
		CreditCardFactory myFactory = new CreditCardFactory();
		ArrayList<CreditCard> myCards = new ArrayList<CreditCard>();
		
		myCards.add(myFactory.makeNewCreditCard("5100123412341234,07/22,John Doe"));
		myCards.add(myFactory.makeNewCreditCard("33333333333165,09/01,Bad Guy"));
		myCards.add(myFactory.makeNewCreditCard("601112341234123,09/23,Jane Doe"));
		
		for(CreditCard c : myCards) {
			System.out.println(c.toString());
		}
		
	}
}
