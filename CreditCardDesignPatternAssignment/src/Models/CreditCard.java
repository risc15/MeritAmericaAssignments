package Models;

public abstract class CreditCard {
	
	// Class attributes:
	
	private long cardNumber;
	private String expDate;
	private String cardHolder;
	private String cardType;
	private boolean valid;
	
	public CreditCard(long cardNumber, String expDate, String cardHolder) {
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.cardHolder = cardHolder;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Override
	public String toString() {
		return this.cardType + ": " + this.cardNumber + ", " + this.expDate + ", " + this.cardHolder;
	}

}
