/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_02_08_2016;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Zadatak_03 {
	/**
	 * Method for printing status of file.
	 * Method counts every text character word and lines that contains text.
	 * @param file it must exist and be 
	 * @throws Exception 
	 */
	public static void printFileTextStatus(File file) throws Exception{
		// if argument is null or file doesnt exist throw exception
		if (file == null) {
			throw new Exception("First argument can't be null.");
		} else if (!file.exists()) {
        	throw new Exception("File doesnt exist!");
        }
		// create reader and variables
		BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        int lines = 0, words = 0, characters = 0;
        // loop as long as there is lines in file
        while ((line = buffer.readLine()) != null) {
        	// reset temp variables and create list using split command
        	String tmpWord = "";
        	char tmpChar = '\u0000';
        	String[] wordsInLine = line.split(" ");
        	// loop for every item in list
            for (String word : wordsInLine) {
            	// loop for every character in item from list
				for (char ch : word.toCharArray()) {
					// if character is valuable count it and change temp character
					if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {characters++; tmpChar = ch;}
				}
				// if temp character is changed count new word and change temp word
				if (tmpChar != '\u0000') {words++; tmpWord = word;}
			}
            // if temp word has changed count line
            if (tmpWord.length() > 0) lines++;
        }
        // print message and close buffer
        System.out.printf("Lines count: %d\nWord count: %d\nCharacter count: %d\n", lines, words, characters);
        buffer.close();
	}
	/**
	 * Main method that use method for counting letter, words and lines of text in file.
	 * If no argument is specified or file doesnt exist program exits.
	 * @param args accepts file path as first argument
	 * @throws IOException is raised if reading of file is not possible
	 */
	public static void main(String[] args) throws IOException {
		// tmp variable for debugging
		args = new String[]{System.getProperty("user.dir") + "\\zadaci_02_08_2016\\test.txt"};
		System.out.println(args[0]);
		// if no argument is specified exit
		if (args == null || args.length == 0) {
			System.out.println("No file name specified as argument.");
			System.exit(0);
		}
		// create file and
        // try to print status of the file or error message if not possible
        try {
        	File file = new File(args[0]);
        	printFileTextStatus(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
}
