/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_10_08_2016;

public class Zadatak_04 {
	/**
	 * Method for checking how many characters are in string that match argument.
	 * @param str Any length string
	 * @param a character that will be used to search string
	 * @return -1 if argument was null,<br>0 if no characters are found in string or<br>count of characters that match argument
	 */
	public static int count(String str, char a) {
		// if string is null reutrn -1
		if (str == null) {
			System.out.println("Cant count occurence of character in string.(null)");
			return -1;
		// if only one character in string return if its match
		} else if (str.length() == 1) return str.charAt(0) == a ? 1 : 0;
		//count all matches and return count
		int count = 0;
		for (char ch : str.toCharArray()) {
			if (ch == a) count++;
		}
		return count;
	}
	/**
	 * Program asks for string and character and then checks how many times character occured in string.
	 * @param args
	 */
	public static void main(String[] args) {
		// collect string
		System.out.print("Enter word or sentence: ");
		String string = zadaci_01_08_2016.Zadatak_02.userInput.nextLine();
		// collect first character from string
		System.out.print("Enter character: ");
		char character = zadaci_01_08_2016.Zadatak_02.userInput.nextLine().charAt(0);
		// print results
		System.out.println(count(string, character));
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
