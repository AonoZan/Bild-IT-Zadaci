/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_10_08_2016;

public class Zadatak_05 {
	/**
	 * Method checks if string contains substring from arguments.
	 * @param string
	 * @param substring
	 * @return
	 */
	public static boolean isSubstring(String string, String substring) {
		if (string == null || substring == null) {										// if arguments are null return false
			System.out.println("Can't check if string has substring(null argument).");
			return false;
		} else if (string.length() < substring.length()) return false;					// if string is smaller also false
		else if (string.length() == substring.length()) return string.equals(substring);// if equal length then return if they are equal
		for (int i = 0; i < string.length() - substring.length(); i++) {				// loop trough string
			if (substring.equals(string.substring(i, i + substring.length()))) {		// and check if there is match to substring
				return true;
			}
		}
		return false;
	}
	/**
	 * Program asks user to enter two strings and then checks if second string is substring of the first.
	 * @param args
	 */
	public static void main(String[] args) {
		// get string
		System.out.print("Enter first string: ");
		String string = zadaci_01_08_2016.Zadatak_02.userInput.nextLine();
		// get substring
		System.out.print("Enter subctring: ");
		String subString = zadaci_01_08_2016.Zadatak_02.userInput.nextLine();
		// print message
		System.out.printf("\"%s\" is substring of \"%s\": ", string, subString);
		System.out.println(isSubstring(string, subString));
	}
}
