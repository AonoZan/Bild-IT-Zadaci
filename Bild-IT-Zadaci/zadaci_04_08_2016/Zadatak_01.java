/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_04_08_2016;

public class Zadatak_01 {
	/**
	 * Method that asks user for one whole number and prints factors of that number on console.
	 * @param args
	 */
	public static void main(String[] args) {
		// create variable for storing user number and ask user for value
		int userNumber = 0;
		while(true) {
			try {
				System.out.print("Enter one integer: ");
				userNumber = zadaci_01_08_2016.Zadatak_02.userInput.nextInt();
				break;
			// if error occurs print message and clean console
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Try again.");
				zadaci_01_08_2016.Zadatak_02.userInput.nextLine();
			}
		}
		// create variable for divider and print factors
		int divider = 2;
		while(userNumber != 0 && userNumber != -1) {
			// if number is divisable with divider print divider and divide number
			if (userNumber % divider == 0) {
				// print positive divider or negatove based on value that user entered
				System.out.printf("%s ", userNumber > 0 ? String.valueOf(divider) : "-" + divider);
				userNumber /= divider;
			}
			// else try other divider
			else divider++;
		}
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
