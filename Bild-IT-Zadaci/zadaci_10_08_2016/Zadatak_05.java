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
	 * Program tests method isSubstring().
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("\"BC\" is substring of \"ABCD\": ");
		System.out.println(isSubstring("ABCD", "BC"));
	}
}
