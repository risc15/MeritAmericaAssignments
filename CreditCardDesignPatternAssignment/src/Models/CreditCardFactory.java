package Models;

public class CreditCardFactory {
	public CreditCard makeNewCreditCard(String input) {
		
		// Get input and put into array:
		String[] cardInfo = input.split(",");
		
		// Verify proper array size and return a dubious card if not:
		if(!(cardInfo.length > 0 && cardInfo.length < 4)) {
			return new DubiousCard(0l,"ERROR","ERROR");
		}
		
		// Verify card number size:
		if(cardInfo[0].length() > 19) {
			return new DubiousCard(0l,"ERROR","ERROR");
		}
		
		// Separate information:
		long cardNumber = Long.parseLong(cardInfo[0]);
		String expDate = cardInfo[1];
		String cardHolder = cardInfo[2];
		String firstFour;
		
		// grab first four numbers if the length is greater than four:
		if (cardInfo[0].length() > 4) {
			firstFour = cardInfo[0].substring(0,4);
		} else {
			firstFour = "0000";
		}
		
		// Past this point, I chose various if statements instead of if/else if statements for readability:
		
		// if (first digit is 2 or 5 AND second digit is 1 to 5 AND length is 16 digits) create MasterCard:
		if( (cardInfo[0].charAt(0) == '2' || cardInfo[0].charAt(0) == '5') && 
				cardInfo[0].charAt(1) <= '5' && cardInfo[0].charAt(1) != '0' &&
				cardInfo[0].length() == 16) {
			return new MasterCard(cardNumber, expDate, cardHolder);
		}
		
		// if (first digit is 4 AND (length is 13 OR length is 16)) create Visa:
		if( cardInfo[0].charAt(0) == '4' && (cardInfo[0].length() == 13 || cardInfo[0].length() == 16) ) {
			return new Visa(cardNumber, expDate, cardHolder);
		}
		
		// if first digit is 3 AND (second digit is 4 or 7) AND length is 15 digits create AmericanExpress:
		if( cardInfo[0].charAt(0) == '3' && ( cardInfo[0].charAt(1) == '4' || cardInfo[0].charAt(1) == '7' ) &&
				cardInfo[0].length() == 15) {
			return new AmericanExpress(cardNumber, expDate, cardHolder);
		}
		
		// if first 4 digits are 6 0 1 1 AND length is 16 create Discover:
		if( firstFour.contentEquals("6011") && cardInfo[0].length() == 16) {
			return new Discover(cardNumber, expDate, cardHolder);
		}
		
		// If none of these work, create dubious card:
		return new DubiousCard(cardNumber, expDate, cardHolder);
	}
}
