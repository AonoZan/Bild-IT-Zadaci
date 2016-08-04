/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_04_08_2016;

public class Zadatak_02 {
	/**
	 * Method asks user to enter 9 values that will be used for calculating ISBN.
	 * If user make mistake while enters values program asks to enter that value again.
	 * <p>Examples of isbn numbers:
	 * <br>013031997X, 0136012671
	 * @see <a href="http://stackoverflow.com/questions/1803670/how-do-you-print-two-places-exactly-using-zero-pad-flag-in-a-print-statement">How to format leading zero numbers</a>
	 * @param args
	 */
	public static void main(String[] args) {
		// create default values
		int checksum = 0, isbn = 0, userNumber;
		// loop for 9 numbers and prompt user each time to enter value
		System.out.println("Enter 9 values for isbn number:");
		for (int i = 1; i <= 9; i++) {
			try {
				System.out.printf("Enter %d value: ", i);
				userNumber = zadaci_01_08_2016.Zadatak_02.userInput.nextInt();
				// if useer enters number but incorrect one reset counter and throw exception
				if (userNumber < 0 || userNumber > 9) {
					i--;
					throw new Exception("Value must be one number from 0 to 9.");
				}
				// if user entered correct value add it to isbn and calculate checksum 
				isbn = isbn * 10 + userNumber;
				checksum += userNumber * i;
			// if error occurs print message and clean console
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Try again.");
				i--;
				zadaci_01_08_2016.Zadatak_02.userInput.nextLine();
			}
		}
		// print isbn number and checksum (if 10 then print X instead of checksum)
		System.out.printf("\nInternational Standard Book Number:"
				+ "\n\tISBN-%09d%s",
				isbn,
				(checksum %= 11) == 10 ? "X" : String.valueOf(checksum));
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
