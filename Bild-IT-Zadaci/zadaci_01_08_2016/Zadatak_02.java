/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_01_08_2016;

public class Zadatak_02 {
	// Create variable that holds Scanner and method that closes it
	private static java.util.Scanner userInput = new java.util.Scanner(System.in);
	private static void closeUserInput() {userInput.close();}
	
	/**
	 * Method that counts vowels in string.<p>
	 * @param sentence String of any length
	 * @return vowel count
	 */
	public static int countVowels(String sentence){
		int vowelsCount = 0;
		// go through whole string for every letter
		for (int i = 0; i < sentence.length(); i++) {
			// increase counter if substring of current letter is vowel
			if ("aeiou".contains(sentence.substring(i, i+1).toLowerCase())) vowelsCount++;
		}
		return vowelsCount;
	}
	/**
	 * Main method that asks for sentence and then prints how many vowels as well as non-vowels are in sentence.<p>
	 * @param args
	 * @see <a href="http://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java">Remove whitespace from string</a>
	 */
	public static void main(String[] args) {
		// ask for sentence and store it in string
		System.out.print("Write word or sentence: ");
		String line = userInput.nextLine();
		
		// create variable for vowels and non-vowels
		// make sure that you count only characters from words
		// and not whitespaces, puncation signs etc.
		int vowelsCount = countVowels(line);
		int non_vowelsCount = line.replaceAll("\\W", "").length() - vowelsCount;
		
		// print status
		System.out.printf("Vowels count in string: %d\nNon-Vowel count: %d\n",
				vowelsCount, non_vowelsCount);
		
		// close Scanner
		closeUserInput();
	}

}
