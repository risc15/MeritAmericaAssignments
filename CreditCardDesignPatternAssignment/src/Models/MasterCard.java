package Models;

public class MasterCard extends CreditCard {

	public MasterCard(long cardNumber, String expDate, String cardHolder) {
		super(cardNumber, expDate, cardHolder);
		setValid(true);
		setCardType("Mastercard");
	}

}
