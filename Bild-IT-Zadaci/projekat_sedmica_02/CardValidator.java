/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package projekat_sedmica_02;

class CardValidator1 {
	private String example = "Working...";
	private boolean status = false;
	private String cardType = null;
	private int[][] numberCrunches;
	public CardValidator1(String number) {
		updateStatus(number);
	}
	// Method that updates everything.
	public void updateStatus(String number) {
		this.cardType = cardType(number.charAt(0), number.charAt(1));
		this.status = checkCard(number);
		this.example = generateExample(number);
	}
	
	public String getExample() {
		return example;
	}
	public boolean isStatus() {
		return status;
	}
	public String getCardType() {
		return cardType;
	}
	public int[][] getNumberCrunches() {
		return numberCrunches;
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
	private String generateExample(String number) {
//		StringBuilder example = new StringBuilder();
		String example = "";
		String lineH = "-----------------";
		String lineW = "| | | | | | | | |";
		boolean fliper = true;
		for (int i = 0; i < numberCrunches.length; i++) {
			if (fliper && numberCrunches[i] != null) {
				if (numberCrunches[i][2] >= 10) {
					example = " (" + numberCrunches[i][3] + " + " + numberCrunches[i][4] + " = " + numberCrunches[i][5] + ")\n" + example;
					example = numberCrunches[i][0] + " * 2 = " + numberCrunches[i][2] + example;
				} else {
					example = numberCrunches[i][0] + " * 2 = " + numberCrunches[i][2] + "\n" + example;
				}
				example = lineW.substring(0, i) + "'" + lineH.substring(0, 16 - i) + "> " + example;
			}
			fliper = !fliper;
		}
		example = number + "\n" + example;
		return example;// .toString();
	}
	private boolean checkCard(String number) {
		this.numberCrunches = new int[16][];
		if (number.length() <= 16) {
			int allSingleDigits = 0, allOdd = 0;
			boolean singleDigit = true;
			for (int i = 0; i < number.length(); i++) {
				int digit = Integer.parseInt(number.substring(i, i+1));
				numberCrunches[i] = new int[6];
				if (singleDigit) {
					numberCrunches[i][0] = digit;
					numberCrunches[i][1] = 2;
					digit *= 2;
					numberCrunches[i][2] = digit;
					if (digit >= 10) {
						numberCrunches[i][3] = digit / 10;
						numberCrunches[i][4] = digit % 10;
						numberCrunches[i][5] = numberCrunches[i][3] + numberCrunches[i][4];
						allSingleDigits += numberCrunches[i][5];
					} else {
						allSingleDigits += digit;
					}
				} else {
					numberCrunches[i][0] = digit;
					allOdd += digit;
				}
				singleDigit = !singleDigit;
			}
			if (numberCrunches[15] == null)
				numberCrunches[15] = new int[6];
			numberCrunches[15][3] = allSingleDigits;
			numberCrunches[15][4] = allOdd;
			numberCrunches[15][5] = allSingleDigits + allOdd;
			return numberCrunches[15][5] % 10 == 0 ? true : false;
		}
		return false;
	}
}
public class CardValidator {
	public static void main(String[] args) {
		CardValidator1 validator = new CardValidator1("43885768");//018402626");
		int[][] list = validator.getNumberCrunches();
		System.out.print(validator.getExample());
	}
}
