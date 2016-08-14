/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package projekat_sedmica_02a;
/**
 * <b>Card Validator</b>
 * @author AonoZan
 * <p>Validates credit card number and generates calculations.
 */
public class CardValidator {
	// String variables that will hold presentation of current card
	private String table = "";
	private String calculations = "";
	// sum of values on equal and odd places of the card
	private int calc1 = 0, calc2 = 0;
	// status of the card (valid or not)
	private boolean status = false;
	// card type eg. Visa
	private String cardType = null;
	
	public CardValidator(String number) {
		updateStatus(number);
	}
	/**
	 * Methiod that updates everything.
	 * @param number Credit card number
	 */
	public void updateStatus(String number) {
		// if less than two caracters in string no calculations
		if (number == null || number.length() < 2) return;
		// set credit card type status and generate table
		this.cardType = cardType(number.charAt(0), number.charAt(1));
		this.status = checkCard(number);
		generateTable(number);
	}
	public String getCalculations() {
		return calculations;
	}
	public String getTable() {
		return table;
	}
	public boolean isStatus() {
		return status;
	}
	public String getCardType() {
		return cardType;
	}
	/**
	 * Method for retriving credit card type eg. Visa.
	 * @param firstNum
	 * @param secondNum
	 * @return
	 */
	private String cardType(char firstNum, char secondNum) {
		if (firstNum == '4') return "Visa";				// for Visa cards
		else if (firstNum == '5') return "Master";		// for Master Card
		else if (firstNum == '6') return "Discover";	// For Discover
		else if (firstNum == '3' && secondNum == '7')	// for American Express cards
			return "American Express";
		return null;
	}
	/**
	 * Method that generates table based on current card
	 * @param number
	 */
	private void generateTable(String number) {
		// if number is empty skip
		if (number == null || number.length() == 0) {
			this.table = "Enter numbers to continue.";
			return;
		}
		// variables for table, odd and equal calculations
		String table = "";
		String calculations1 = "";
		String calculations2 = "";
		// strings for making arrows on the table
		String lineH = "-----------------";
		String lineW = "| | | | | | | | |";
		boolean fliper = true;
		// loop over card number
		for (int i = 0; i < number.length(); i++) {
			// get current number
			int digit = Integer.parseInt(number.substring(i, i+1));
			// for equal numbers add to table and calculations appropriate string
			if (fliper) {
				switch (digit) {
					case 0:
						table = "0 * 2 = 0\n" + table;
						calculations1 = calculations1 + "0";
						break;
					case 1:
						table = "1 * 2 = 2\n" + table;
						calculations1 = calculations1 + "2";
						break;
					case 2:
						table = "2 * 2 = 4\n" + table;
						calculations1 = calculations1 + "4";
						break;
					case 3:
						table = "3 * 2 = 6\n" + table;
						calculations1 = calculations1 + "6";
						break;
					case 4:
						table = "4 * 2 = 8\n" + table;
						calculations1 = calculations1 + "8";
						break;
					case 5:
						table = "5 * 2 = 10 (1 + 0 = 1)\n" + table;
						calculations1 = calculations1 + "1";
						break;
					case 6:
						table = "6 * 2 = 12 (1 + 2 = 3)\n" + table;
						calculations1 = calculations1 + "3";
						break;
					case 7:
						table = "7 * 2 = 14 (1 + 4 = 5)\n" + table;
						calculations1 = calculations1 + "5";
						break;
					case 8:
						table = "8 * 2 = 16 (1 + 6 = 7)\n" + table;
						calculations1 = calculations1 + "7";
						break;
					case 9:
						table = "9 * 2 = 18 (1 + 8 = 9)\n" + table;
						calculations1 = calculations1 + "9";
						break;
					default:
						break;
				}
				// generate arrow
				table = lineW.substring(0, i) + "'" + lineH.substring(0, 16 - i) + "> " + table;
				// add plus or equal sign
				if (i < number.length()-2) {
					calculations1 = calculations1 + " + ";
				} else {
					calculations1 = calculations1 + " = " + this.calc1;
				}
			// for numbers on odd places
			} else {
				// generate calculations and add plus or equal sign
				calculations2 = calculations2 + digit;
				if (i < number.length()-2) {
					calculations2 = calculations2 + " + ";
				} else {
					calculations2 = calculations2 + " = " + this.calc2;
				}
			}
			fliper = !fliper;
		}
		// add number on top of the table
		table = number + "\n" + table;
		// add final calculations
		calculations2 = calculations2 + " ==> " + calc1 + " + " + calc2 + " = " + (calc1 + calc2);
		calculations2 = calculations2 + " ==> " + (calc1 + calc2) + " % 10 = " + (calc1 + calc2) % 10;
		// set calculations
		this.calculations = calculations1 + "\n" + calculations2 + "\n";
		this.table = table;
	}
	/**
	 * Method for checking if credit card number is valid or not.
	 * @param number
	 * @return
	 */
	private boolean checkCard(String number) {
		// if number is less than 16 digits
		if (number.length() <= 16) {
			// variables for sum of all numbers on odd and equal places
			int allSingleDigits = 0, allOdd = 0;
			boolean singleDigit = true;
			// loop trough number
			for (int i = 0; i < number.length(); i++) {
				// parse string into digit
				int digit = Integer.parseInt(number.substring(i, i+1));
				// for all equal calculate sum
				if (singleDigit) {
					digit *= 2;
					if (digit >= 10) {
						allSingleDigits += (digit / 10) + (digit % 10);
					} else {
						allSingleDigits += digit;
					}
				// for all odd digits calculate sum
				} else {
					allOdd += digit;
				}
				singleDigit = !singleDigit;
			}
			// set values
			this.calc1 = allSingleDigits;
			this.calc2 = allOdd;
			// return if card is valid or not
			return (allSingleDigits + allOdd) % 10 == 0 ? true : false;
		}
		return false;
	}
}
