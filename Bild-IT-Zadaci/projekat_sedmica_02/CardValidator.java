/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package projekat_sedmica_02;

import javax.xml.bind.helpers.ValidationEventLocatorImpl;

import zadaci_01_08_2016.Zadatak_02;

class CardValidator1 {
	String example = "Working...";
	String status = null;
	private String cardType = null;
	int[][] numberCrunches;
	public CardValidator1(String number) {
		updateStatus(number);
	}
	// Method that updates everything.
	public void updateStatus(String number) {
		this.cardType = cardType(number.charAt(0), number.charAt(1));
		this.example = updateExample(number);
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
	//4388576018402626
	private String updateExample(String number) {
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
//					System.out.printf("%d %d\n", allSingleDigits, allOdd);
				} else {
					numberCrunches[i][0] = digit;
					allOdd += digit;
				}
				singleDigit = !singleDigit;
			}
			return String.format("%d %d", allSingleDigits, allOdd);
		}
		return "Number too long.";
	}
}
public class CardValidator {
	public static void main(String[] args) {
		CardValidator1 validator = new CardValidator1("4388576018402626");
		System.out.println(validator.example);
		int[][] list = validator.numberCrunches;
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				System.out.printf("%2d ", list[i][j]);
			}
			System.out.println();
		}
	}
}
