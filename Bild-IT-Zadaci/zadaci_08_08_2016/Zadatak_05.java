/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_08_08_2016;

public class Zadatak_05 {
	/**
	 * Program asks for user password and checks if it's valid.
	 * <p><b>Password is valid if:</b>
	 * <ol>
	 * 	<li>It's length is at least 8 characters</li>
	 * 	<li>Has at least 2 digits</li>
	 * 	<li>Contains only letters and numbers</li>
	 * </ol>
	 * @param args
	 */
	public static void main(String[] args) {
		// prompt for password
		System.out.print("Enter your password: ");
		String password = zadaci_01_08_2016.Zadatak_02.userInput.nextLine();
		// if password has less than 8 characters exit
		if (password.length() < 8) {
			System.out.println("Password is not valid.\nPassword must be at least 8 characters.");
			System.exit(0);
		}
		// check characters if are valid and count digits
		int numberCount = 0;
		for (char ch : password.toCharArray()) {
			if (!Character.isAlphabetic(ch) && !Character.isDigit(ch)) {
				System.out.printf("Password is not valid.\n%c is not valid character.");
				System.exit(0);
			} else if (Character.isDigit(ch)) numberCount++;
		}
		// if less than 2 digits exit else print that password is correct
		if (numberCount < 2) {
			System.out.println("Password is not valid.\nPassword has to have at least 2 digits.");
			System.exit(0);
		} else {
			System.out.println("Password is valid.");
		}
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
