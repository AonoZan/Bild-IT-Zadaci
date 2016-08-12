/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package projekat_sedmica_02;

class CardValidator1 {
	private String table = "Enter numbers to continue.";
	private String calculations = "";
	private int calc1 = 0, calc2 = 0;
	private boolean status = false;
	private String cardType = null;
	public CardValidator1(String number) {
		updateStatus(number);
	}
	// Method that updates everything.
	public void updateStatus(String number) {
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
	// get card type if valid if not return null
	private String cardType(char firstNum, char secondNum) {
		if (firstNum == '4') return "Visa";				// for Visa cards
		else if (firstNum == '5') return "Master";		// for Master Card
		else if (firstNum == '6') return "Discover";	// For Discover
		else if (firstNum == '3' && secondNum == '7')	// for American Express cards
			return "American Express";
		return null;
	}
	private void generateTable(String number) {
		if (number == null || number.length() == 0) {
			this.table = "Enter numbers to continue.";
			return;
		}
		String table = "";
		String calculations1 = "";
		String calculations2 = "";
		String lineH = "-----------------";
		String lineW = "| | | | | | | | |";
		boolean fliper = true;
		for (int i = 0; i < number.length(); i++) {
			int digit = Integer.parseInt(number.substring(i, i+1));
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
				table = lineW.substring(0, i) + "'" + lineH.substring(0, 16 - i) + "> " + table;
				if (i < number.length()-2) {
					calculations1 = calculations1 + " + ";
				} else {
					calculations1 = calculations1 + " = " + this.calc1;
				}
			} else {
				calculations2 = calculations2 + digit;
				if (i < number.length()-2) {
					calculations2 = calculations2 + " + ";
				} else {
					calculations2 = calculations2 + " = " + this.calc2;
				}
			}
			fliper = !fliper;
		}
		table = number + "\n" + table;
		this.calculations = calculations1 + "\n" + calculations2 + "\n";
		this.table = table;
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
			this.calc1 = allSingleDigits;
			this.calc2 = allOdd;
			return (allSingleDigits + allOdd) % 10 == 0 ? true : false;
		}
		return false;
	}
}
public class CardValidator {
	public static void main(String[] args) {
		CardValidator1 validator = new CardValidator1("4388576018410707");
		System.out.print(validator.getTable());
		System.out.print(validator.getCalculations());
		System.out.println(validator.getCardType());
		System.out.println(validator.isStatus());
		validator.updateStatus("4388576018402626");
		System.out.print(validator.getTable());
		System.out.print(validator.getCalculations());
		System.out.println(validator.getCardType());
		System.out.println(validator.isStatus());
	}
}
