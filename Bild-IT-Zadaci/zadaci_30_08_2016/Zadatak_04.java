
package zadaci_30_08_2016;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/** Method counts lines, words and characters from the string. */
	public static void count(String file) {
		// variables for count
		int lines = 0, words = 0, characters = 0;
		// loop over file spliced in lines
		for (String line : file.split("\n")) {
			// if line is not empty
			if (line.length() > 0) {
				// store current number of characters
				int tmpChars = characters;
				// loop over all words in line
				for (String word : line.split(" ")) {
					tmpChars = characters;
					// count alphabetical characters if any
					for (char ch : word.toCharArray()) {
						if (Character.isAlphabetic(ch)) characters++;
					}
					// if number of characters increased then it's new word
					if (characters > tmpChars) words++;
				}
				// if number of characters increased then it's new line
				if (characters > tmpChars) lines++;
			}
		}
		// print statistic
		System.out.println("Character count: " + characters);
		System.out.println("Word count: " + words);
		System.out.println("Lines count: " + lines);
	}
	public static void main (String[] args) throws IOException {
		// get filename from parameters and create file
        File file = new File(args[0]);
        Scanner fileInput = new Scanner(file);
        // read whole file and print formated
		String content = fileInput.useDelimiter("\\Z").next();
		count(content);
		fileInput.close();
    }
}
