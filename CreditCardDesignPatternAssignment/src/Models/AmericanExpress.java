package Models;

public class AmericanExpress extends CreditCard {

	public AmericanExpress(long cardNumber, String expDate, String cardHolder) {
		super(cardNumber, expDate, cardHolder);
		setValid(true);
		setCardType("American Express");
	}

}
