/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_05_08_2016;

public class Zadatak_05 {
	/**
	 * Method counts how many letters string containd
	 * @param s String of any length.
	 * @return Number of letters in string or 0 if null is passed as argument
	 */
	public static int countLetters(String s) {
		// return 0 if null is passed
		if (s == null) {
			System.out.println("Can't count letters(null as argument).");
			return 0;
		}
		// go trough whole string and check how much letters it contain
		int counter = 0;
		for (char ch : s.toCharArray()) {
			if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') counter++;
		}
		return counter;
	}
	/**
	 * MAin method that asks user to enter string and then it prints how many letters were in string.
	 * @param args
	 */
	public static void main(String[] args) {
		// prompt user to enter string
		System.out.print("Enter string: ");
		String userString = zadaci_01_08_2016.Zadatak_02.userInput.nextLine();
		// count letters and print count to the console
		int letters = countLetters(userString);
		System.out.printf("String contains %d letters.", letters);
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
