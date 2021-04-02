package Models;

public class Visa extends CreditCard {

	public Visa(long cardNumber, String expDate, String cardHolder) {
		super(cardNumber, expDate, cardHolder);
		setValid(true);
		setCardType("Visa");
	}

}
