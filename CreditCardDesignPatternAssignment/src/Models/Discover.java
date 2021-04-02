package Models;

public class Discover extends CreditCard{

	public Discover(long cardNumber, String expDate, String cardHolder) {
		super(cardNumber, expDate, cardHolder);
		setValid(true);
		setCardType("Discover");
	}

}
