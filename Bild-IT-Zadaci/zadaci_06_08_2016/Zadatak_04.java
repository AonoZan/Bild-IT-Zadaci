/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_06_08_2016;

public class Zadatak_04 {
	/**
	 * Simple program that asks user to enter string and it displays stripped version of that string.
	 * <p><b>Example:</b>
	 * <br>Enter word or sentence: Beijing Chicago
	 * <br>Striped version: BiigCiao
	 * @param args
	 */
	public static void main(String[] args) {
		// prompt user to enter string
		System.out.print("Enter word or sentence: ");
		String userString = zadaci_01_08_2016.Zadatak_02.userInput.nextLine();
		// display stripped version
		System.out.print("Striped version: ");
		boolean fliper = false;
		for (char ch : userString.toCharArray()) {
			// if character is alphabetic print character and flip flipper else reset fliper
			if (Character.isAlphabetic(ch)) System.out.printf("%s", (fliper = !fliper) ? ch + "" : "");
			else fliper = false;
		}
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
