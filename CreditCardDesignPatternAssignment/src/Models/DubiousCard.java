package Models;

public class DubiousCard extends CreditCard {

	public DubiousCard(long cardNumber, String expDate, String cardHolder) {
		super(cardNumber, expDate, cardHolder);
		setValid(false);
		setCardType("Dubious");
	}
	
	@Override
	public String toString() {
		return "Unable to instantiate from known credit types: " + getCardNumber() + "," + getExpDate() + "," + getCardHolder();
	}

}
