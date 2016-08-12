/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package projekat_sedmica_02;

class CardValidator1 {
	private String table = "Working...";
	private boolean status = false;
	private String cardType = null;
	public CardValidator1(String number) {
		updateStatus(number);
	}
	// Method that updates everything.
	public void updateStatus(String number) {
		this.cardType = cardType(number.charAt(0), number.charAt(1));
		this.status = checkCard(number);
		this.table = generateTable(number);
	}
	
	public String getExample() {
		return table;
	}
	public boolean isStatus() {
		return status;
	}
	public String getCardType() {
		return cardType;
	}
	// get card type if valid if not return null
	private String cardType(char firstNum, char secondNum) {
		if (firstNum == '4') return "Visa";				// for Visa cards
		else if (firstNum == '5') return "Master";		// for Master Card
		else if (firstNum == '6') return "Discover";	// For Discover
		else if (firstNum == '3' && secondNum == '7')	// for American Express cards
			return "American Express";
		return null;
	}
	private String generateTable(String number) {
//		StringBuilder example = new StringBuilder();
		String example = "";
		String lineH = "-----------------";
		String lineW = "| | | | | | | | |";
		for (int i = 0; i < number.length(); i+=2) {
				int digit = Integer.parseInt(number.substring(i, i+1));
				switch (digit) {
					case 0:
						example = "0 * 2 = 0\n" + example;
						break;
					case 1:
						example = "1 * 2 = 2\n" + example;
						break;
					case 3:
						example = "3 * 2 = 6\n" + example;
						break;
					case 4:
						example = "4 * 2 = 8\n" + example;
						break;
					case 5:
						example = "5 * 2 = 10 (1 + 0 = 1)\n" + example;
						break;
					case 6:
						example = "6 * 2 = 12 (1 + 2 = 3)\n" + example;
						break;
					case 7:
						example = "7 * 2 = 14 (1 + 4 = 5)\n" + example;
						break;
					case 8:
						example = "8 * 2 = 16 (1 + 6 = 7)\n" + example;
						break;
					case 9:
						example = "9 * 2 = 18 (1 + 8 = 9)\n" + example;
						break;
					default:
						break;
				}
				example = lineW.substring(0, i) + "'" + lineH.substring(0, 16 - i) + "> " + example;
		}
		example = number + "\n" + example;
		return example;// .toString();
	}
	private boolean checkCard(String number) {
		if (number.length() <= 16) {
			int allSingleDigits = 0, allOdd = 0;
			boolean singleDigit = true;
			for (int i = 0; i < number.length(); i++) {
				int digit = Integer.parseInt(number.substring(i, i+1));
				if (singleDigit) {
					digit *= 2;
					if (digit >= 10) {
						allSingleDigits += (digit / 10) + (digit % 10);
					} else {
						allSingleDigits += digit;
					}
				} else {
					allOdd += digit;
				}
				singleDigit = !singleDigit;
			}
			return (allSingleDigits + allOdd) % 10 == 0 ? true : false;
		}
		return false;
	}
}
public class CardValidator {
	public static void main(String[] args) {
		CardValidator1 validator = new CardValidator1("43885768");//018402626");
		System.out.print(validator.getExample());
		validator.updateStatus("45");
		System.out.print(validator.getExample());
	}
}
